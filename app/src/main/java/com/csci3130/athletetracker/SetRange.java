package com.csci3130.athletetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetRange extends AppCompatActivity {

    AthleteHeartRate athleteHeartRate;

    EditText setMinimumHeartRate, setMaximumHeartRate, setMinimumSteps, setMaximumSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_range);

        setMinimumHeartRate = (EditText) findViewById(R.id.et_heartRateMinimum);
        setMinimumHeartRate.setText(Integer.toString(AthleteHeartRate.heartRateMin));

        setMaximumHeartRate = (EditText) findViewById(R.id.et_heartRateMaximum);
        setMaximumHeartRate.setText(Integer.toString(AthleteHeartRate.heartRateMax));

        setMinimumSteps = (EditText) findViewById(R.id.et_stepsMinimum);
        setMaximumSteps = (EditText) findViewById(R.id.et_stepsMaximum);

        setupButtons();
    }

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

    private void goToMainScreen() {

        saveMinMaxValues();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void saveMinMaxValues(){
        AthleteHeartRate.heartRateMin = Integer.parseInt(setMinimumHeartRate.getText().toString());
        AthleteHeartRate.heartRateMax = Integer.parseInt(setMaximumHeartRate.getText().toString());
    }

    private void resetRangeValuesDefault(){
        athleteHeartRate.resetRangeToDefault();
        ((EditText)findViewById(R.id.et_heartRateMinimum)).setText(Integer.toString(AthleteHeartRate.defaultHeartRateMin), TextView.BufferType.EDITABLE);
        ((EditText)findViewById(R.id.et_heartRateMaximum)).setText(Integer.toString(AthleteHeartRate.defaultHeartRateMax), TextView.BufferType.EDITABLE);
    }

}
