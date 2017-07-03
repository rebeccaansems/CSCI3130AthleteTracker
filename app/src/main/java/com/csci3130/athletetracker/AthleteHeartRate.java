package com.csci3130.athletetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rebecca Ansems on 2017-06-01.
 */

public class AthleteHeartRate {

    private int currentHeartRate = 80;
    public static int heartRateMin, heartRateMax;
    public static int defaultHeartRateMin = 60, defaultHeartRateMax = 120;

    //This allows for testing without Hexiwear data
    public void setCurrentHeartRate(int heartRate){
        currentHeartRate = heartRate;
    }

    public int getHeartRate(){
        return currentHeartRate;
    }

    public void setHeartRateRange(int min, int max){
        heartRateMin = min;
        heartRateMax = max;
    }

    public boolean isHeartRateInRange(){
        return isHeartRateInRange(currentHeartRate);
    }

    public boolean isHeartRateInRange(int heartRate){
        if(heartRate > heartRateMin && heartRate < heartRateMax){
            return true;
        }
        return false;
    }

    public static void resetRangeToDefault(){
        heartRateMin = defaultHeartRateMin;
        heartRateMax = defaultHeartRateMax;
    }
}
