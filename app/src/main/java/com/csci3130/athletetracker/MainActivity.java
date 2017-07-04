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
    }

    public void gotoRangeScreen(){
        Intent intent = new Intent(this, SetRange.class);
        startActivity(intent);
    }

    public void gotoHistoricalDataScreen(){
        Intent intent = new Intent(this, HistoricalData.class);
        startActivity(intent);
    }
}
