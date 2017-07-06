package com.csci3130.athletetracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dpeck on 2017-07-03.
 */

public class GraphFragment extends android.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.graph_fragment,
                container, false);

        //DrawGraph graph = new DrawGraph();

        //graph.drawGraph();

        return view;
    }
}
