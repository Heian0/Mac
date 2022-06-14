package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Set;
import java.util.Hashtable;

public class Tracker extends AppCompatActivity {

    private TrackerHandler trackerHandler = new TrackerHandler();
    private DictHandler dictHandler = new DictHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        ViewGroup trackerVG = (ViewGroup) findViewById(R.id.trackerVG);

        for (String key : dictHandler.testDict.keySet())
        {
            trackerHandler.displayNewItem(dictHandler.testDict.get(key), trackerVG, this);
        }
    }
}