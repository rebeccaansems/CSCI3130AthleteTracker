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

/**
 * Main activity class that can go the all the other class
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenedMainScreen();
    }

    public void OpenedMainScreen() {
        // Set Range Button
        final Button gotoRangeScreenButton = (Button) findViewById(R.id.b_gotoSetRangeScreen);
        gotoRangeScreenButton.setOnClickListener(new View.OnClickListener() {
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

        // Send User Message Button
        final Button gotoSendUserMessageButton = (Button) findViewById(R.id.b_gotoSendMessage);
        gotoSendUserMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoSendUserMessageScreen();
            }
        });
    }

    /**
     * gotoRangeScreen method that will go to the set range screen
     */
    public void gotoRangeScreen(){
        Intent intent = new Intent(this, SetRange.class);
        startActivity(intent);
    }

    /**
     * gotoHistoricalDataScreen method that will go to the historical data screen
     */
    public void gotoHistoricalDataScreen(){
        Intent intent = new Intent(this, HistoricalData.class);
        startActivity(intent);
    }

    /**
     * gotoSendUserMessage method that will go to the send user message screen
     */
    public void gotoSendUserMessageScreen(){
        Intent intent = new Intent(this, SendUserMessage.class);
        startActivity(intent);
    }
}
