package com.example.autoservice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class ListenService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //showNotification();
    }

    private void showNotification() {

        NotificationManager notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        Bitmap btm = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("新消息提醒")
                .setContentText("您有一条新申请，点击查看！");
        mBuilder.setTicker("新消息");//第一次提示消息的时候显示在通知栏上
        mBuilder.setNumber(12);
        mBuilder.setLargeIcon(btm);
        mBuilder.setAutoCancel(true);//自己维护通知的消失

        //构建一个Intent
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("extra", "extra");
        //封装一个Intent
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        // 设置通知主题的意图
        mBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(1, mBuilder.build());

    }

}
