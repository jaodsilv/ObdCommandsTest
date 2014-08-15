package com.kantil.app.commandstest.activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.kantil.app.commandstest.R;
import com.kantil.app.commandstest.asyncTask.RunCommandsTask;

public class MainActivity extends Activity {

	private TableLayout table;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		table = (TableLayout) findViewById(R.id.table);
		table.setHorizontalScrollBarEnabled(true);
		adView = new AdView(this);
		adView.setAdUnitId("ca-app-pub-0405505984373789/2498190018");
		adView.setAdSize(AdSize.BANNER);

		((Button) findViewById(R.id.tryAgain))
				.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						collectData();
					}
				});

		LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
		layout.addView(adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		adView.loadAd(adRequest);
	}

	public void collectData() {
		RunCommandsTask task = new RunCommandsTask(this, table);
		task.execute();
	}

	public void bluetoothPairDeviceView() {
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

	public void bluetoothTurnOnView() {
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

	@Override
	public void onPause() {
		adView.pause();
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		adView.resume();
	}

	@Override
	public void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}
}
