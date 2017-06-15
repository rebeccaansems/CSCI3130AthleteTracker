package com.csci3130.athletetracker;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;

/**
 * Created by rainb on 2017/6/8.
 */

public class AthleteSteps extends AppCompatActivity {

    public int StepsMin;
    public int StepsMax;
    private int CurrentSteps;

    //get range numbers from the input text fields
    public void sendMessage(View view) {
        EditText TextStepsMin = (EditText) findViewById(R.id.et_stepsMinimum);
        String temp1 = TextStepsMin.getText().toString();

        StepsMin = Integer.valueOf(temp1);//min number of the range set by the user

        EditText TextStepsMax = (EditText) findViewById(R.id.et_stepsMaximum);
        String temp2 = TextStepsMin.getText().toString();

        StepsMax = Integer.valueOf(temp2);//max number of the range set by the user
    }


    //allow testing without Hexiwear data
    public void setCurrentSteps(int steps) {
        CurrentSteps = steps;
    }

    public int getSteps(){
        return CurrentSteps;
    }

    public void setStepsRange(int min,int max){
        StepsMin = min;
        StepsMax = max;
    }


    //set notifications for different steps numbers
    //this part is optional and it is not contained in the user story
    /*
    public String StepsStatus(int steps){
        String message="";
        if(steps < 5000)
            message = "You moved less than 3000 steps today, not up to standard.";
        if(steps>=5000 && steps<8000)
            message = "You moved more than 5000 steps today, you can do better.";
        if(steps>=8000 && steps<10000)
            message = "You moved more than 8000 steps today, just a little away from 10000 steps";
        if(steps>=10000&&steps<15000)
            message = "You moved more than 10000 steps today, well done!";
        if(steps>=15000)
            message = "Wonderful job! You moved more than 15000 steps today.";

        return message;
    }
    */

    public boolean isStepInRange(){return isStepInRange(CurrentSteps);}

    public boolean isStepInRange(int steps){
        if(steps > StepsMin && steps < StepsMax)
            return true;

        return false;
    }

}
