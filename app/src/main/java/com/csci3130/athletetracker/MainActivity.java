package com.csci3130.athletetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button goToRangeScreenButton = (Button)findViewById(R.id.b_gotoSetRangeScreen);
        goToRangeScreenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                gotoRangeScreen();
            }
        });

        Button goToHistoricalDataButton = (Button)findViewById(R.id.b_goToHistoricalDataScreen);
        goToHistoricalDataButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToHistoricalDataScreen();
            }
        });
    }

    public void OpenedMainScreen(){
        final Button goToRangeScreenButton = (Button)findViewById(R.id.b_gotoSetRangeScreen);
        goToRangeScreenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                gotoRangeScreen();
            }
        });
    }

    public void OpenedRangeScreen(){
        final Button goToMainScreenFromRangeScreenButton = (Button)findViewById(R.id.b_rangeBackToMainScreen);
        goToMainScreenFromRangeScreenButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToMainScreen();
            }
        });
    }

    public void gotoRangeScreen(){
        setContentView(R.layout.activity_historical_data);
        OpenedRangeScreen();
    }

    public void goToMainScreen(){
        setContentView(R.layout.activity_main);
        OpenedMainScreen();
    }

    public void goToHistoricalDataScreen(){
        Intent i=new Intent(MainActivity.this, HistoricalData.class);
        startActivity(i);
        //setContentView(R.layout.activity_historical_data);
        //OpenedRangeScreen();
    }
}
