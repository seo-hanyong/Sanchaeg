package no1s.sanchaeg.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import no1s.sanchaeg.R;

/**
 * Created by yong on 2018/07/16.
 */

public class testService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DEBUG", "called testService.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("DEBUG", "called testService.onStartCommand()");
        String channelId = "service";
        String title = "testService";

        // 通知設定
        NotificationManager notificationManager =
                (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel =
                new NotificationChannel(channelId, title, NotificationManager.IMPORTANCE_DEFAULT);

        if(notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(getApplicationContext(), channelId)
                    .setContentTitle(title)
                    .setSmallIcon(R.drawable.menu)
                    .setContentText("service start")
                    .build();

            // フォアグラウンドで実行
            startForeground(1, notification);

            // 10秒後にログ出力
            try {
                Thread.sleep(10000);
                Log.i("INFO", "processing service");
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("DEBUG", "called testService.onDestroy()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
