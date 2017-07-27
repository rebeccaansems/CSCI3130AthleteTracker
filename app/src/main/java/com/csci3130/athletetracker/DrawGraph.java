package com.csci3130.athletetracker;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DrawGraph extends Activity {

    LineChart heartRateGraph;
    BarChart stepsGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_graph);
        drawHeartRateGraph();
        drawStepsGraph();
    }

    /**
     * method to draw the line graph for the heart rate
     */
    public void drawHeartRateGraph(){
        heartRateGraph = (LineChart) findViewById(R.id.lineChart);

        ArrayList<String> xAxes = new ArrayList<>();
        ArrayList<Entry> yAxes = new ArrayList<>();

        double x = 0;
        int numDataPoints = 31;

        Random rand = new Random();

        for (int i = 0; i < numDataPoints; i++) {
            //float point = rand.nextFloat()+80;
            int point = rand.nextInt((70)+1) + 80;
            x = x + 0.1;
            yAxes.add(new Entry(i, point));
            //xAxes.add(i, String.valueOf(x));
            for (int j = 0; j < 31; j++) {
                xAxes.add(j, String.valueOf(j));
            }
        }

        String [] xaxes = new String[xAxes.size()];

        for (int i = 0; i < xAxes.size(); i++) {
            xaxes[i] = xAxes.get(i).toString();
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(yAxes, "Average heart rate per day for the month");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);

        heartRateGraph.setData(new LineData(lineDataSets));

        heartRateGraph.setVisibleYRange(0f,100f, YAxis.AxisDependency.LEFT);
        //heartRateGraph.setVisibleXRangeMaximum(100f);
        Description description = new Description();
        description.setText(" ");
        heartRateGraph.setDescription(description);
    }

    /**
     * method to draw the bar graph for the steps
     */
    public void drawStepsGraph(){
        stepsGraph = (BarChart) findViewById(R.id.barChart);

        ArrayList<String> xAxes = new ArrayList<>();
        ArrayList<Entry> yAxes = new ArrayList<>();

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        double x = 0;
        int numDataPoints = 31;

        Random rand = new Random();

        for (int i = 0; i < numDataPoints; i++) {
            //float point = rand.nextFloat()+5000;
            int point = rand.nextInt(20000)+3000;
            x = x + 0.1;
            barEntries.add(new BarEntry(i,point));
            yAxes.add(new Entry(point, i));
            //xAxes.add(i, String.valueOf(x));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Steps per day for the month");


        String [] xaxes = new String[xAxes.size()];

        /*
        for (int i = 0; i < xAxes.size(); i++) {
            xaxes[i] = xAxes.get(i).toString();
        }
        */

        stepsGraph.setData(new BarData(barDataSet));

        stepsGraph.setVisibleYRange(0f,25000f, YAxis.AxisDependency.LEFT);
        //stepsGraph.setVisibleXRangeMaximum(100f);
        Description description = new Description();
        description.setText("");
        stepsGraph.setDescription(description);

    }
}
