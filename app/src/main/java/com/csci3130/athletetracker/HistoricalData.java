package com.csci3130.athletetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
/*
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
*/
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random; // for FireBase filling

/**
 * Displays and uses the data from hexiwear
 */
public class HistoricalData extends AppCompatActivity {

    Spinner spinner;

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

    /** Upon creation set the data for the spinner and
     * the data for the rest of the page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_data2);




        DatabaseReference Database = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mHistory = Database.child("HistoricalData");

        /*
         * fill FireBase with random data.
         */
        /*
        mHistory.child("January");
        mHistory.child("February");
        mHistory.child("March");
        mHistory.child("April");
        mHistory.child("May");
        mHistory.child("June");
        mHistory.child("July");
        mHistory.child("August");
        mHistory.child("September");
        mHistory.child("October");
        mHistory.child("November");
        mHistory.child("December");
        *

        mHistory.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i = 0; i < 1; i++ ){

                    Random rand = new Random();

                    int month = rand.nextInt(12) + 1;
                    int day = rand.nextInt(30) + 1;
                    int HR = rand.nextInt(100) + 100;
                    int steps = rand.nextInt(30000);

                    History h = new History(HR, steps);

                    if(month == 1) {
                        mHistory.child("January").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 2) {
                        mHistory.child("February").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 3) {
                        mHistory.child("March").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 4) {
                        mHistory.child("April").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 5) {
                        mHistory.child("May").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 6) {
                        mHistory.child("June").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 7) {
                        mHistory.child("July").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 8) {
                        mHistory.child("August").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 9) {
                        mHistory.child("September").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 10) {
                        mHistory.child("October").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 11) {
                        mHistory.child("November").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                    if(month == 12) {
                        mHistory.child("December").child("" + months[month] + " " + day + ", 2017").setValue(h);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*
         * end of Firebase filling code
         */

        spinner = (Spinner) findViewById(R.id.s_dateSpinner);

            /*
             *TextView. this is Where the Data from FireBase will be displayed
             *  Month day. Year
             *  tab HR: #, Steps: #
             */
        final TextView monthData = (TextView) findViewById(R.id.showData2);

            /*
             * 3 buttons to show and hide TextView, HeartRate graph and Steps graph
             */
        final Button buttonMonthData = (Button) findViewById(R.id.buttonMonthData);

        final Button buttonGraph = (Button) findViewById(R.id.buttonGraph);
        buttonGraph.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoGraphScreen();
            }
        });

            /*
             * TextView and 3 buttons to filter data.
             */
        final TextView filterBy = (TextView) findViewById(R.id.filterBy);

        final Button filterBoth = (Button) findViewById(R.id.filterBoth);
        final Button filterHR = (Button) findViewById(R.id.filterHR);
        final Button filterSteps = (Button) findViewById(R.id.filterSteps);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, months);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        // get int position of the selected month from spinner, to use later to get month String
                        int position = spinner.getSelectedItemPosition();

                            /*
                             * Filter by Heart Rate and Steps onClick filter by Both
                             */
                        filterBoth.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                // clear textView every time the spinner is used (changing months)
                                monthData.setText("");
                                //for loop to go through every day in the chosen month
                                for (int i = 1; i < 31; i++){
                                    // get the number of index from spinner to use later to get the chosen month from months array
                                    int j = spinner.getSelectedItemPosition();
                                    // we get an Error due to not having any data assigned to index 0 in months array in firebase
                                    //this if statment just make sure that we dont try to call for NULL from Firebase
                                    if(spinner.getSelectedItemPosition()== 0){
                                        j = 1;
                                    }
                                       /*
                                        * in fire base data are save in Historical data
                                        * inside historical data ( child of historical data) we have months
                                        * months[j] give us the chosen month
                                        * inside each month there are multiple children
                                        * each child is named by the date
                                        *
                                        * this is for reading from firebase
                                        */
                                    mHistory.child(""+months[j]).child(""+months[j]+" "+i+", 2017").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        // take a datasnapshot for the date
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            // get the name of the day (date)
                                            //month day, year
                                            monthData.setText(monthData.getText().toString() +dataSnapshot.getKey() +"\n\t\t\t");
                                            //get the historical object from datasnapshot
                                            History history = dataSnapshot.getValue(History.class);
                                            //get value for Heart Rate and number of steps from the historical object
                                            String info = "HR: " + history.getHR() + ", Steps: " + history.getSteps() + "\n";
                                            // add the HR and steps to the textView
                                            monthData.setText(monthData.getText().toString()+ info);
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                        }
                                    });
                                }

                                monthData.setVisibility(View.VISIBLE);

                                buttonMonthData.setVisibility(View.VISIBLE);
                                buttonGraph.setVisibility(View.VISIBLE);

                                final Button gotoGraphScreenButton = (Button) findViewById(R.id.buttonGraph);
                                gotoGraphScreenButton.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        gotoGraphScreen();
                                    }
                                });
                            }
                        });

                            /*
                             * Filter by Heart Rate onClick filter by Heart Rate
                             */
                        filterHR.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                monthData.setText("");
                                for (int i = 1; i < 31; i++){
                                    int j = spinner.getSelectedItemPosition();
                                    if(spinner.getSelectedItemPosition()== 0)
                                        j = 1;
                                    mHistory.child(""+months[j]).child(""+months[j]+" "+i+", 2017").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            monthData.setText(monthData.getText().toString() +dataSnapshot.getKey() +"\n\t\t\t");
                                            History history = dataSnapshot.getValue(History.class);
                                            // only call getHR() to get HR
                                            String info = "HR: " + history.getHR() + "\n";
                                            monthData.setText(monthData.getText().toString()+ info);
                                        }
                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                        }
                                    });
                                }
                                monthData.setVisibility(View.VISIBLE);
                                buttonMonthData.setVisibility(View.VISIBLE);
                                buttonGraph.setVisibility(View.VISIBLE);

                                /*
                                final Button gotoGraphScreenButton = (Button) findViewById(R.id.buttonGraph);
                                gotoGraphScreenButton.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        gotoGraphScreen();
                                    }
                                });
                                */
                            }
                        });

                            /*
                             * Filter by Steps onClick filter by steps
                             */
                        filterSteps.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                monthData.setText("");
                                for (int i = 1; i < 31; i++){
                                    int j = spinner.getSelectedItemPosition();
                                    if(spinner.getSelectedItemPosition()== 0)
                                        j = 1;
                                    mHistory.child(""+months[j]).child(""+months[j]+" "+i+", 2017").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            monthData.setText(monthData.getText().toString() +dataSnapshot.getKey() +"\n\t\t\t");
                                            History history = dataSnapshot.getValue(History.class);
                                            // only call getSteps() to get Steps
                                            String info = "Steps: " + history.getSteps() + "\n";
                                            monthData.setText(monthData.getText().toString()+ info);

                                        }
                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                        }
                                    });
                                }
                                monthData.setVisibility(View.VISIBLE);
                                buttonMonthData.setVisibility(View.VISIBLE);
                                buttonGraph.setVisibility(View.VISIBLE);


                            }
                        });

                        if (position > 0) {
                            // when the user select anything other than "select" from the spinner set everything to visible
                            filterBy.setVisibility(View.VISIBLE);

                            filterBoth.setVisibility(View.VISIBLE);
                            filterHR.setVisibility(View.VISIBLE);
                            filterSteps.setVisibility(View.VISIBLE);
                        } else {
                            //other wise hide everything
                            monthData.setVisibility(View.GONE);

                            buttonMonthData.setVisibility(View.GONE);
                            buttonGraph.setVisibility(View.GONE);


                            filterBy.setVisibility(View.GONE);

                            filterBoth.setVisibility(View.GONE);
                            filterHR.setVisibility(View.GONE);
                            filterSteps.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );


        final Button gotoGraphScreenButton = (Button) findViewById(R.id.buttonGraph);
        gotoGraphScreenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoGraphScreen();
            }
        });

    }

    public void gotoGraphScreen(){
        Intent intent = new Intent(this, DrawGraph.class);
        startActivity(intent);
    }

    public void buttonMonthData(View view) {
        TextView monthData = (TextView) findViewById(R.id.showData2);

        TextView filterBy = (TextView) findViewById(R.id.filterBy);

        Button filterBoth = (Button) findViewById(R.id.filterBoth);
        Button filterHR = (Button) findViewById(R.id.filterHR);
        Button filterSteps = (Button) findViewById(R.id.filterSteps);

        //BarChart hrGraph = (BarChart) findViewById(R.id.hrGraph);
        //BarChart stepsGraph = (BarChart) findViewById(R.id.stepsGraph);

        monthData.setVisibility(View.VISIBLE);

        filterBy.setVisibility(View.VISIBLE);
        filterBoth.setVisibility(View.VISIBLE);
        filterHR.setVisibility(View.VISIBLE);
        filterSteps.setVisibility(View.VISIBLE);

        //hrGraph.setVisibility(View.GONE);
        //stepsGraph.setVisibility(View.GONE);
    }
    public void buttonGraph(View view) {
        TextView monthData = (TextView) findViewById(R.id.showData2);

        TextView filterBy = (TextView) findViewById(R.id.filterBy);
        Button filterBoth = (Button) findViewById(R.id.filterBoth);
        Button filterHR = (Button) findViewById(R.id.filterHR);
        Button filterSteps = (Button) findViewById(R.id.filterSteps);

        //BarChart hrGraph = (BarChart) findViewById(R.id.hrGraph);
        //BarChart stepsGraph = (BarChart) findViewById(R.id.stepsGraph);

        monthData.setVisibility(View.GONE);

        filterBy.setVisibility(View.GONE);
        filterBoth.setVisibility(View.GONE);
        filterHR.setVisibility(View.GONE);
        filterSteps.setVisibility(View.GONE);

        //hrGraph.setVisibility(View.VISIBLE);
        //stepsGraph.setVisibility(View.GONE);
    }
    public void buttonSteps(View view) {
        TextView monthData = (TextView) findViewById(R.id.showData2);

        TextView filterBy = (TextView) findViewById(R.id.filterBy);
        Button filterBoth = (Button) findViewById(R.id.filterBoth);
        Button filterHR = (Button) findViewById(R.id.filterHR);
        Button filterSteps = (Button) findViewById(R.id.filterSteps);

        //BarChart hrGraph = (BarChart) findViewById(R.id.hrGraph);
        //BarChart stepsGraph = (BarChart) findViewById(R.id.stepsGraph);

        monthData.setVisibility(View.GONE);
        filterBy.setVisibility(View.GONE);

        filterBoth.setVisibility(View.GONE);
        filterHR.setVisibility(View.GONE);
        filterSteps.setVisibility(View.GONE);

        //hrGraph.setVisibility(View.GONE);
        //stepsGraph.setVisibility(View.VISIBLE);
    }

    /*public void filterBoth(View view) {

    }

    public void filterHR(View view) {

    }

    public void filterSteps(View view) {

    }*/
}
@IgnoreExtraProperties
class History {

    public int hr;
    public int steps;

    public History() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public History(int hr, int steps) {
        this.hr = hr;
        this.steps = steps;
    }

    public int getHR() {
        return hr;
    }

    public int getSteps() {
        return steps;
    }
}