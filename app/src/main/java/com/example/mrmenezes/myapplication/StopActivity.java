package com.example.mrmenezes.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Eric on 26/05/2016.
 */
public class StopActivity extends Activity {

    NotificationManager manager;
    Notification myNotication;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_notification);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Log.d("TAGTEST","STOP");
        start();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void start(){
        //API level 11
        Intent intent = new Intent(this,StartActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(StopActivity.this, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(StopActivity.this);

        builder.setAutoCancel(false);
        builder.setTicker("Comece a dirigir");
        builder.setContentTitle("Notificação do Aplicativo");
        builder.setContentText("Clique aqui para iniciar");
        builder.setSmallIcon(R.drawable.abc);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setNumber(100);
        builder.build();

        myNotication = builder.getNotification();
        manager.notify(11, myNotication);
    }
}