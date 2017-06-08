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
        OpenedMainScreen();
    }

    public void OpenedMainScreen() {
        final Button goToRangeScreenButton = (Button) findViewById(R.id.b_gotoSetRangeScreen);
        goToRangeScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoRangeScreen();
            }
        });
    }

    public void gotoRangeScreen(){
        Intent intent = new Intent(this, SetRange.class);
        startActivity(intent);
    }


}
