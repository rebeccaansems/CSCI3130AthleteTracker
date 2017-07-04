package com.csci3130.athletetracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Contains methods associated with heart rate tracking and ranges
 */

public class AthleteHeartRate {

    private int currentHeartRate = 80;
    public static int heartRateMin, heartRateMax;
    public static int defaultHeartRateMin = 60, defaultHeartRateMax = 120;

    /** Allows testing of methods without hexiwear data
     *
     * @param heartRate the current heart rate
     */
    public void setCurrentHeartRate(int heartRate){
        currentHeartRate = heartRate;
    }

    /** Gets the current/most recent heart rate
     *
     * @return current/most recent heart rate
     */
    public int getHeartRate(){
        return currentHeartRate;
    }

    /** Sets the range where heart rate is good
     *
     * @param min the lowest heart rate that is acceptable
     * @param max the highest heart rate that is acceptable
     */
    public void setHeartRateRange(int min, int max){
        heartRateMin = min;
        heartRateMax = max;
    }

    /** Checks if current heart rate is within the set range
     *
     * @return boolean that says if heart rate is in range
     */
    public boolean isHeartRateInRange(){
        return isHeartRateInRange(currentHeartRate);
    }

    /** Checks if given heart rate is within the set range
     *
     * @param heartRate heart rate to test
     * @return boolean that says if heart rate is in range
     */
    public boolean isHeartRateInRange(int heartRate){
        if(heartRate > heartRateMin && heartRate < heartRateMax){
            return true;
        }
        return false;
    }

    /** Sets heart beat range, min and max, to their defaults
     * min default is 60, max default is 120
     */
    public static void resetRangeToDefault(){
        heartRateMin = defaultHeartRateMin;
        heartRateMax = defaultHeartRateMax;
    }
}
