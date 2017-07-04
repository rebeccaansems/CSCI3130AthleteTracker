package com.csci3130.athletetracker;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HistoricalData extends AppCompatActivity {

    Spinner spinner;

    DrawGraph graph;

    String[] months = {
            "Select...",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_data2);

        spinner = (Spinner)findViewById(R.id.s_dateSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, months);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spinner.getSelectedItemPosition();
                        //final Fragment juneGraph = (Fragment) findViewById(graphFragment);


                        if (position == 6){
                            gotoDrawGraphScreen();
                            //juneGraph.setVisibility(View.VISIBLE);
                        }
                        else {
                            //juneData.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );


    }

    public void gotoDrawGraphScreen(){
        Intent intent = new Intent(this, DrawGraph.class);
        startActivity(intent);
    }


}
