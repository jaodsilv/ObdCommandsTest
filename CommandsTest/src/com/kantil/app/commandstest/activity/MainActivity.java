package com.kantil.app.commandstest.activity;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.kantil.app.commandstest.R;
import com.kantil.app.commandstest.command.Comando;
import com.kantil.app.commandstest.command.ObdCommand;
import com.kantil.app.commandstest.util.Logger;

public class MainActivity extends Activity {

	private TableLayout table;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		table = (TableLayout) findViewById(R.id.table);
		table.setHorizontalScrollBarEnabled(true);

		((Button) findViewById(R.id.tryAgain))
				.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						coletaDados();
					}
				});
	}

	public void coletaDados() {
		final BluetoothAdapter bluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (bluetoothAdapter == null) {
			// There is no bluetooth adapter in the phone
			Toast.makeText(this, getString(R.string.noBluetooth),
					Toast.LENGTH_LONG).show();
			Toast.makeText(this, getString(R.string.incompatibleDevice),
					Toast.LENGTH_LONG).show();
			Toast.makeText(this, getString(R.string.tryAnotherPhone),
					Toast.LENGTH_LONG).show();
		} else if (bluetoothAdapter.isEnabled()) {
			if (thereArePairedBluetoothDevices()) {
				try {
					Set<BluetoothDevice> devicesSet = bluetoothAdapter
							.getBondedDevices();
					Set<BluetoothDevice> obdDevicesSet = new HashSet<BluetoothDevice>();
					for (BluetoothDevice device : devicesSet) {
						if (device.getName().equals("OBDII"))
							obdDevicesSet.add(device);
					}

					BluetoothSocket sock = null;

					for (BluetoothDevice dev : obdDevicesSet) {
						Logger.i("BT",
								"Trying connection with " + dev.getAddress());
						// Entra e conecta no primeiro odb que
						// funcionar
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
						throw new InterruptedException("No Device Connected");
					in = sock.getInputStream();
					out = sock.getOutputStream();
					Logger.d("DEBUG", "OIOIOI");

					String result = null;
					while ((result == null || !result.contains("OK"))) {
						ObdCommand echoOff = new ObdCommand("ate0");
						result = runCommand(echoOff, in, out).replace(" ", "");
					}
					Logger.d("DEBUG", "OIOIOI2");
					String VIN = null;
					while ((VIN == null)) {
						ObdCommand vinCommand = new ObdCommand(
								Comando.Code0902.getCodigo());
						VIN = runCommand(vinCommand, in, out).replace(" ", "");
					}
					int i = 0;
					table.removeAllViewsInLayout();
					TableRow row = new TableRow(getApplicationContext());
					TableRow.LayoutParams lp = new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT);
					row.setLayoutParams(lp);
					TextView t = new TextView(getApplicationContext());
					t.setText("Descrição");
					row.addView(t, 0);
					t = new TextView(getApplicationContext());
					t.setText("Codigo");
					row.addView(t, 1);
					t = new TextView(getApplicationContext());
					t.setText("dataBytes");
					row.addView(t, 2);
					t = new TextView(getApplicationContext());
					t.setText("min");
					row.addView(t, 3);
					t = new TextView(getApplicationContext());
					t.setText("max");
					row.addView(t, 4);
					t = new TextView(getApplicationContext());
					t.setText("Unidade");
					row.addView(t, 5);
					t = new TextView(getApplicationContext());
					t.setText("Formula");
					row.addView(t, 6);
					t = new TextView(getApplicationContext());
					t.setText("Resultado");
					row.addView(t, 7);
					table.addView(row, i++);
					for (Comando c : Comando.values()) {
						result = runCommand(new ObdCommand(c.getCodigo()), in,
								out);

						if (!result.equals("NODATA")) {
							TextView comando = new TextView(
									getApplicationContext());
							comando.setTextColor(Color.BLACK);
							comando.setText(c.getDescricao());

							TextView codigo = new TextView(
									getApplicationContext());
							codigo.setTextColor(Color.BLACK);
							codigo.setText(c.getCodigo());

							TextView dataBytes = new TextView(
									getApplicationContext());
							dataBytes.setTextColor(Color.BLACK);
							dataBytes.setText("" + c.getDataBytes());

							TextView min = new TextView(getApplicationContext());
							min.setTextColor(Color.BLACK);
							min.setText("" + c.getMin());

							TextView max = new TextView(getApplicationContext());
							max.setTextColor(Color.BLACK);
							max.setText("" + c.getMax());

							TextView unidade = new TextView(
									getApplicationContext());
							unidade.setTextColor(Color.BLACK);
							unidade.setText(c.getUnidade());

							TextView formula = new TextView(
									getApplicationContext());
							formula.setTextColor(Color.BLACK);
							formula.setText(c.getFormula());

							TextView resultado = new TextView(
									getApplicationContext());
							resultado.setTextColor(Color.BLACK);
							resultado.setText(result);

							row = new TableRow(getApplicationContext());
							lp = new TableRow.LayoutParams(
									TableRow.LayoutParams.WRAP_CONTENT);
							row.setLayoutParams(lp);
							row.addView(comando, 0);
							row.addView(codigo, 1);
							row.addView(dataBytes, 2);
							row.addView(min, 3);
							row.addView(max, 4);
							row.addView(unidade, 5);
							row.addView(formula, 6);
							row.addView(resultado, 7);
							table.addView(row, i++);
						}

					}
					sock.close();
				} catch (Exception e) {
					Toast.makeText(this, "tente novamente", Toast.LENGTH_LONG)
							.show();
				}

			} else {
				bluetoothPairDeviceView();
				Toast.makeText(this, "tente novamente", Toast.LENGTH_LONG)
						.show();
			}
		} else {
			bluetoothTurnOnView();
			Toast.makeText(this, "tente novamente", Toast.LENGTH_LONG).show();
		}
	}

	public String runCommand(ObdCommand cmd, InputStream in, OutputStream out)
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

	private void bluetoothPairDeviceView() {
		LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View popupView = layoutInflater.inflate(
				R.layout.popup_pair_device, null);
		final PopupWindow popupWindow = new PopupWindow(popupView,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		Button gps = (Button) popupView.findViewById(R.id.bound);
		gps.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivityForResult(new Intent(
						Settings.ACTION_BLUETOOTH_SETTINGS), 0);
				popupWindow.dismiss();
			}
		});

		Button cancelar = (Button) popupView.findViewById(R.id.cancelar);
		cancelar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				popupWindow.dismiss();
			}
		});

		popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
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

	private void bluetoothTurnOnView() {
		LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View popupView = layoutInflater.inflate(R.layout.popup_bluetooth,
				null);
		final PopupWindow popupWindow = new PopupWindow(popupView,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		Button bluetooth = (Button) popupView.findViewById(R.id.bluetooth);
		bluetooth.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivityForResult(new Intent(
						BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
				popupWindow.dismiss();
			}
		});

		Button cancelar = (Button) popupView.findViewById(R.id.cancelar);
		cancelar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				popupWindow.dismiss();
			}
		});

		popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
	}

}
