package com.example.autoservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoServiceBroadReceiver extends BroadcastReceiver {

	private final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

	@Override

	public void onReceive(Context context, Intent intent) {

		if (ACTION_BOOT.equals(intent.getAction())) {

			Intent myIntent = new Intent(context, ListenService.class);
			context.startService(myIntent);

		}

	}

}
