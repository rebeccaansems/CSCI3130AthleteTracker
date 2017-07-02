package com.csci3130.athletetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenedMainScreen();
    }

    public void OpenedMainScreen() {
        final Button goToRangeScreenButton = (Button) findViewById(R.id.b_gotoSetRangeScreen);
        goToRangeScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoRangeScreen();
            }
        });

            // Historical Data Button
        final Button gotoHistoricalDataScreenButton = (Button) findViewById(R.id.b_gotoHistoricalData);
        gotoHistoricalDataScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoHistoricalDataScreen();
            }
        });

        final Button notifyScreenButton = (Button) findViewById(R.id.b_notifyButton);
        notifyScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notifyUser();
            }
        });
    }

    public void gotoRangeScreen(){
        Intent intent = new Intent(this, SetRange.class);
        startActivity(intent);
    }

    public void gotoHistoricalDataScreen(){
        Intent intent = new Intent(this, HistoricalData.class);
        startActivity(intent);
    }


    //send the heart rate notification to user
    public void notifyUser(){
        Intent intent = new Intent(MainActivity.this, AthleteHeartRate.class);
        PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(MainActivity.this);

        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Hearty365")
                .setContentTitle("Heart Rate Notification")
                .setContentText("Heyyyy your heart rate out of range! Are you okay?")
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, b.build());
    }
}
