package com.csci3130.athletetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**the class setting the range of the heart rate and steps
 *
 */
public class SetRange extends AppCompatActivity {

    AthleteHeartRate athleteHeartRate;

    EditText setMinimumHeartRate, setMaximumHeartRate, setMinimumSteps, setMaximumSteps;

    /**onCreate method create the variable for edit text fields
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_range);

        athleteHeartRate = new AthleteHeartRate();

        setMinimumHeartRate = (EditText) findViewById(R.id.et_heartRateMinimum);
        setMinimumHeartRate.setText(Integer.toString(AthleteHeartRate.heartRateMin));

        setMaximumHeartRate = (EditText) findViewById(R.id.et_heartRateMaximum);
        setMaximumHeartRate.setText(Integer.toString(AthleteHeartRate.heartRateMax));

        setMinimumSteps = (EditText) findViewById(R.id.et_stepsMinimum);
        setMaximumSteps = (EditText) findViewById(R.id.et_stepsMaximum);

        setupButtons();
    }

    /**setupButtons methods create two buttons that reset the range and go back to main screen
     *
     */
    private void setupButtons(){
        final Button resetRangeValues = (Button) findViewById(R.id.b_resetToDefaultRange);
        resetRangeValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRangeValuesDefault();
            }
        });

        final Button goToMainScreenFromRangeScreenButton = (Button) findViewById(R.id.b_rangeBackToMainScreen);
        goToMainScreenFromRangeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainScreen();
            }
        });
    }

    /**go to main screen method will bring back to the main screen
     *
     */
    private void goToMainScreen() {

        saveMinMaxValues();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**save min max values method will save the values for max and min
     *
     */
    private void saveMinMaxValues(){
        AthleteHeartRate.heartRateMin = Integer.parseInt(setMinimumHeartRate.getText().toString());
        AthleteHeartRate.heartRateMax = Integer.parseInt(setMaximumHeartRate.getText().toString());

        NotifyUserHeartRateRange();
    }

    /** reset range method will reset the heart rate range to default
     * and will call the NotifyUserHeartRateRange if they set it out of range
      *
     */
    private void resetRangeValuesDefault(){
        athleteHeartRate.resetRangeToDefault();
        ((EditText)findViewById(R.id.et_heartRateMinimum)).setText(Integer.toString(AthleteHeartRate.defaultHeartRateMin), TextView.BufferType.EDITABLE);
        ((EditText)findViewById(R.id.et_heartRateMaximum)).setText(Integer.toString(AthleteHeartRate.defaultHeartRateMax), TextView.BufferType.EDITABLE);

        NotifyUserHeartRateRange();
    }

    /**NotifyUserHeartRateRange method will send the heart rate notification to user
     * when the user set the heart rate out of range
     *
     */
    public void NotifyUserHeartRateRange(){
        if(!athleteHeartRate.isHeartRateInRange()){
            Intent intent = new Intent(SetRange.this, AthleteHeartRate.class);
            PendingIntent contentIntent = PendingIntent.getActivity(SetRange.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder b = new NotificationCompat.Builder(SetRange.this);

            b.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setTicker("Hearty365")
                    .setContentTitle("Heart Rate Notification")
                    .setContentText("Hey your heart rate is "+athleteHeartRate.getHeartRate()+" and is out of range!\n Are you okay?")
                    .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                    .setContentIntent(contentIntent)
                    .setContentInfo("Info");


            NotificationManager notificationManager = (NotificationManager) SetRange.this.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, b.build());
       }
    }

}
