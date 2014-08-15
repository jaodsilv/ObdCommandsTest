package com.kantil.app.commandstest.asyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.kantil.app.commandstest.R;
import com.kantil.app.commandstest.activity.MainActivity;
import com.kantil.app.commandstest.command.CommandsEnum;
import com.kantil.app.commandstest.command.ObdCommand;
import com.kantil.app.commandstest.util.Logger;
import com.kantil.app.commandstest.util.OutputToFileHandler;

public class RunCommandsTask extends AsyncTask<Void, CommandsEnum, Integer> {

	private static final int success = 0;
	private static final int noBluetoothAdapterError = 1;
	private static final int bluetoothAdapterOff = 2;
	private static final int noPairedOBDDevice = 3;
	private static final int failureConnectingDevice = 4;
	private static final int failureOnDeviceConnection = 5;
	private MainActivity activity;
	private ProgressDialog dialog;
	private TableLayout table;
	private boolean cancel;
	private TableRow row;
	private int i;

	public RunCommandsTask(MainActivity mainActivity, TableLayout table) {
		this.activity = mainActivity;
		this.table = table;
	}

	public void onPreExecute() {
		dialog = new ProgressDialog(activity);
		dialog.setTitle(activity.getString(R.string.testing_data));
		dialog.setMessage(activity.getString(R.string.please_wait));
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setIndeterminate(false);
		dialog.setOnCancelListener(new OnCancelListener() {
			public void onCancel(DialogInterface pd) {
				cancel = true;
			}
		});
		cancel = false;
		dialog.setMax(activity.getResources().getInteger(
				R.integer.number_of_commands));
		dialog.show();

		cancel = false;
		dialog.show();
	}

	@Override
	protected Integer doInBackground(Void... arg0) {
		final BluetoothAdapter bluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (bluetoothAdapter == null) {
			// There is no bluetooth adapter in the phone
			return noBluetoothAdapterError;
		} else if (bluetoothAdapter.isEnabled()) {
			if (thereArePairedBluetoothDevices()) {
				Set<BluetoothDevice> devicesSet = bluetoothAdapter
						.getBondedDevices();
				Set<BluetoothDevice> obdDevicesSet = new HashSet<BluetoothDevice>();
				for (BluetoothDevice device : devicesSet) {
					if (cancel)
						break;
					if (device.getName().equals("OBDII")) // For this
															// Version just
															// devices with
															// name OBDII
						obdDevicesSet.add(device);
				}

				BluetoothSocket sock = null;

				try {
					for (BluetoothDevice dev : obdDevicesSet) {
						if (cancel)
							break;
						Logger.i("BT",
								"Trying connection with " + dev.getAddress());
						// Enter and connect to the first obd device that works
						BluetoothSocket socket = dev
								.createRfcommSocketToServiceRecord(UUID
										.fromString("00001101-0000-1000-8000-00805F9B34FB"));
						socket.connect();
						sock = socket;
						if (sock.isConnected())
							Logger.i("BT",
									"connection succeeded: " + dev.getAddress());
						else
							Logger.w("BT",
									"connection failed: " + dev.getAddress());
						break;
					}

					InputStream in = null;
					OutputStream out = null;

					if (sock == null)
						throw new IOException("Failure connecting OBD device");
					in = sock.getInputStream();
					out = sock.getOutputStream();

					String result = null;
					while (((result == null || !result.contains("OK")) && !cancel)) {
						ObdCommand echoOff = new ObdCommand("ate0");
						result = runCommand(echoOff, in, out).replace(" ", "");
					}
					String VIN = null;// testing if its connected via VIN, may
					// not work
					while (VIN == null && !cancel) {
						ObdCommand vinCommand = new ObdCommand(
								CommandsEnum.Code0902.getCode());
						VIN = runCommand(vinCommand, in, out).replace(" ", "");
					}
					i = 0;
					OutputToFileHandler.cleanFile(activity);
					table.removeAllViewsInLayout();
					row = new TableRow(activity);
					TableRow.LayoutParams lp = new TableRow.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT);
					row.setLayoutParams(lp);
					TextView t = new TextView(activity);
					t.setText(R.string.description);
					row.addView(t, 0);
					t = new TextView(activity);
					t.setText(R.string.code);
					row.addView(t, 1);
					publishProgress((CommandsEnum[]) null);

					for (CommandsEnum c : CommandsEnum.values()) {
						if (cancel)
							break;
						publishProgress(c);
						result = runCommand(new ObdCommand(c.getCode()), in,
								out);

						if (!result.equals("NODATA")) {
							TextView comando = new TextView(activity);
							comando.setTextColor(Color.BLACK);
							comando.setText(c.getDescription());

							TextView codigo = new TextView(activity);
							codigo.setTextColor(Color.BLACK);
							codigo.setText(c.getCode());

							row = new TableRow(activity);
							lp = new TableRow.LayoutParams(
									TableRow.LayoutParams.MATCH_PARENT);
							row.setLayoutParams(lp);
							row.addView(comando, 0);
							row.addView(codigo, 1);
							publishProgress((CommandsEnum[]) null);
							OutputToFileHandler.insertRow(c, result);
						}

					}
					sock.close();
				} catch (IOException e) {
					e.printStackTrace();
					return failureConnectingDevice;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					return failureOnDeviceConnection;
				}
				return success;
			} else {
				return noPairedOBDDevice;
			}
		} else {
			return bluetoothAdapterOff;
		}
	}

	@Override
	protected void onProgressUpdate(CommandsEnum... values) {
		super.onProgressUpdate(values);
		if (values == ((CommandsEnum[]) null))
			table.addView(row, i++);
		else {
			dialog.incrementProgressBy(1);
			dialog.setMessage("Testing command " + values[0].getDescription());
		}
	}

	@Override
	protected void onPostExecute(Integer result) {
		dialog.dismiss();
		switch (result) {
		case noBluetoothAdapterError:
			Toast.makeText(activity, activity.getString(R.string.no_bluetooth),
					Toast.LENGTH_LONG).show();
			Toast.makeText(activity,
					activity.getString(R.string.incompatible_device),
					Toast.LENGTH_LONG).show();
			Toast.makeText(activity,
					activity.getString(R.string.try_another_phone),
					Toast.LENGTH_LONG).show();
			break;
		case bluetoothAdapterOff:
			activity.bluetoothTurnOnView();
			Toast.makeText(activity, R.string.try_again, Toast.LENGTH_LONG)
					.show();
			break;
		case noPairedOBDDevice:
			activity.bluetoothPairDeviceView();
			Toast.makeText(activity, R.string.try_again, Toast.LENGTH_LONG)
					.show();
			break;
		case failureConnectingDevice:
			Toast.makeText(activity, R.string.failed_connecting_obd_device,
					Toast.LENGTH_LONG).show();
			Toast.makeText(activity, R.string.try_again, Toast.LENGTH_LONG)
					.show();
			break;

		}
	}

	private boolean thereArePairedBluetoothDevices() {
		Set<BluetoothDevice> devicesSet = BluetoothAdapter.getDefaultAdapter()
				.getBondedDevices();
		for (BluetoothDevice device : devicesSet) {
			if (device.getName().equals("OBDII"))
				return true;
		}
		return false;
	}

	private String runCommand(ObdCommand cmd, InputStream in, OutputStream out)
			throws InterruptedException {
		cmd.setInputStream(in);
		cmd.setOutputStream(out);
		cmd.start();
		while (true) {
			cmd.join(250);
			if (!cmd.isAlive()) {
				break;
			}
		}
		return cmd.formatResult();
	}

}
