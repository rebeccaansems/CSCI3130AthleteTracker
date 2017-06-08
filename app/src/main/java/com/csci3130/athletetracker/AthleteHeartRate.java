package com.csci3130.athletetracker;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rebecca Ansems on 2017-06-01.
 */

public class AthleteHeartRate {

    private int currentHeartRate;
    public int heartRateMin, heartRateMax;

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

    public void resetRangeToDefault(){
        heartRateMin = 60;
        heartRateMax = 120;
    }
}
