package com.example.autoservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ListenService extends Service {
	private NotificationManager notificationManager;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		showNotification();
		super.onCreate();
	}

	@SuppressWarnings("deprecation")
	private void showNotification() {
		Notification n = new Notification(R.drawable.ic_launcher, "通知",
				System.currentTimeMillis());
		// 3.指定通知的标题、内容和intent
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		n.setLatestEventInfo(this, "标题", "内容", pi);
		// 指定声音
		// n.defaults = Notification.DEFAULT_SOUND;
		// 4.发送通知
		notificationManager.notify(1, n);

	}

}
