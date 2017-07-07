package com.csci3130.athletetracker;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by rainb on 2017/6/8.
 */

public class AthleteSteps extends AppCompatActivity {

    public static int StepsMin;
    public static int StepsMax;


    private int CurrentSteps;


    public void setStepsRange(int min, int max){
        StepsMin = min;
        StepsMax = max;
    }

    //allow testing without Hexiwear data
    public void setCurrentSteps(int steps) {
        CurrentSteps = steps;
    }

    public int getSteps(){
        return CurrentSteps;
    }


    public boolean isStepInRange(){return isStepInRange(CurrentSteps);}

    public boolean isStepInRange(int steps){
        if(steps > StepsMin && steps < StepsMax)
            return true;

        return false;
    }

}
