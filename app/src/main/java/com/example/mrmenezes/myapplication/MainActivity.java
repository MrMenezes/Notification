package com.example.mrmenezes.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnShow, btnClear;
    NotificationManager manager;
    Notification myNotication;
    static boolean innit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShowNotification);
        btnClear = (Button) findViewById(R.id.btnClearNotification);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(!innit){
            start();
            innit=true;
        }

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                stop();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                start();
            }
        });


    }



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void stop(){
        //API level 11
        Intent intent = new Intent(this,StopActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(MainActivity.this);

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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void start(){
        //API level 11
        Intent intent = new Intent(this,StartActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(MainActivity.this);

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