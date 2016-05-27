package com.example.mrmenezes.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Eric on 26/05/2016.
 */
public class StartActivity extends Activity {

    NotificationManager manager;
    Notification myNotication;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_notification);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Log.d("TAGTEST","START");
        stop();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void stop(){
        //API level 11
        Intent intent = new Intent(this,StopActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(StartActivity.this, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(StartActivity.this);

        builder.setAutoCancel(false);
        builder.setTicker("Parar de dirigir");
        builder.setContentTitle("Notificação do Aplicativo");
        builder.setContentText("Clique aqui para parar");
        builder.setSmallIcon(R.drawable.abc);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setNumber(101);
        builder.build();

        myNotication = builder.getNotification();
        manager.notify(11, myNotication);
    }

}