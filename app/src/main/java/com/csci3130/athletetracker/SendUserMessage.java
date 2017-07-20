package com.csci3130.athletetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rebecca Ansems on 2017-07-18.
 */

public class SendUserMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, 225);

        Button sendMessage1 = (Button) findViewById(R.id.b_sendMessage1);
        sendMessage1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(((EditText) findViewById(R.id.et_athletePhoneNumber)).getText().toString(),
                        ((Button) findViewById(R.id.b_sendMessage1)).getText().toString());
            }
        });

        Button sendMessage2 = (Button) findViewById(R.id.b_sendMessage2);
        sendMessage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(((EditText) findViewById(R.id.et_athletePhoneNumber)).getText().toString(),
                        ((Button) findViewById(R.id.b_sendMessage2)).getText().toString());
            }
        });

        Button sendMessage3 = (Button) findViewById(R.id.b_sendMessage3);
        sendMessage3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(((EditText) findViewById(R.id.et_athletePhoneNumber)).getText().toString(),
                        ((Button) findViewById(R.id.b_sendMessage3)).getText().toString());
            }
        });

        Button sendMessage4 = (Button) findViewById(R.id.b_sendMessage4);
        sendMessage4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendSMS(((EditText) findViewById(R.id.et_athletePhoneNumber)).getText().toString(),
                        ((Button) findViewById(R.id.b_sendMessage4)).getText().toString());
            }
        });
    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();

        if(phoneNumber.length() < 9){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage(((EditText) findViewById(R.id.et_athletePhoneNumber)).getText().toString()+" is not a valid phone number");
            dlgAlert.setTitle("Invalid Phone Number...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
        } else {
            sms.sendTextMessage(phoneNumber, null, message, null, null);

            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Message sent successfully to athlete");
            dlgAlert.setTitle("Message Sent");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
        }
    }
}
