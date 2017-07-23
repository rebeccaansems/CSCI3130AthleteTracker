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
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Random;

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


    public void drawHeartRateGraph(){
        heartRateGraph = (LineChart) findViewById(R.id.lineChart);

        ArrayList<String> xAxes = new ArrayList<>();
        ArrayList<Entry> yAxes = new ArrayList<>();

        double x = 0;
        int numDataPoints = 31;

        Random rand = new Random();

        for (int i = 0; i < numDataPoints; i++) {
            float point = rand.nextFloat()+80;
            x = x + 0.1;
            yAxes.add(new Entry(point, i));
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

        LineDataSet lineDataSet1 = new LineDataSet(yAxes, "heart rate");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);

        heartRateGraph.setData(new LineData(lineDataSets));

        heartRateGraph.setVisibleXRangeMaximum(100f);
        Description description = new Description();
        description.setText("Heart Rate Graph");
        heartRateGraph.setDescription(description);
    }

    public void drawStepsGraph(){
        stepsGraph = (BarChart) findViewById(R.id.barChart);

        ArrayList<String> xAxes = new ArrayList<>();
        ArrayList<Entry> yAxes = new ArrayList<>();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(8f, 0));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(12f, 2));
        barEntries.add(new BarEntry(2f, 3));
        barEntries.add(new BarEntry(14f, 4));

        BarDataSet barDataSet = new BarDataSet(barEntries, "steps");
        double x = 0;
        int numDataPoints = 31;

        Random rand = new Random();
        float dummySteps;

        for (int i = 0; i < numDataPoints; i++) {
            float point = rand.nextFloat()+5000;
            x = x + 0.1;
            dummySteps = rand.nextInt(1000);
            barEntries.add(new BarEntry(point,i));
            yAxes.add(new Entry(i, i));
            xAxes.add(i, String.valueOf(x));
        }

        String [] xaxes = new String[xAxes.size()];

        for (int i = 0; i < xAxes.size(); i++) {
            xaxes[i] = xAxes.get(i).toString();
        }

        stepsGraph.setData(new BarData(barDataSet));

        stepsGraph.setVisibleXRangeMaximum(100f);
        Description description = new Description();
        description.setText("Steps Graph");
        stepsGraph.setDescription(description);

    }
}
