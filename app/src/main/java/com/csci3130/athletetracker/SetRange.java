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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        athleteHeartRate = new AthleteHeartRate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_range);

        final Button goToMainScreenFromRangeScreenButton = (Button) findViewById(R.id.b_rangeBackToMainScreen);
        goToMainScreenFromRangeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainScreen();
            }
        });

        final Button resetRangeValues = (Button) findViewById(R.id.b_resetToDefaultRange);
        resetRangeValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRangeValuesDefault();
            }
        });
    }

    private void goToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void resetRangeValuesDefault(){
        athleteHeartRate.resetRangeToDefault();
        ((EditText)findViewById(R.id.et_heartRateMinimum)).setText(athleteHeartRate.heartRateMin+"", TextView.BufferType.EDITABLE);
        ((EditText)findViewById(R.id.et_heartRateMaximum)).setText(athleteHeartRate.heartRateMax+"", TextView.BufferType.EDITABLE);
    }

}
