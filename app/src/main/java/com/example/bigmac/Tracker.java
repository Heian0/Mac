package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Enumeration;

public class Tracker extends AppCompatActivity {

    private TrackerHandler trackerHandler = new TrackerHandler();
    private DictHandler dictHandler = new DictHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        ViewGroup trackerLayout = (ViewGroup) findViewById(R.id.trackerCLay);
        Item itemy = new Item("asd", 1, 1, 1, 1, 1, 1);
        dictHandler.addItemToDict(dictHandler.testDict, itemy);
        Enumeration<String> e = dictHandler.testDict.keys();
        while (e.hasMoreElements())
        {
            System.out.println("hjajdbak");
            String key = e.nextElement();
            trackerHandler.displayNewItem(dictHandler.testDict.get(key), trackerLayout, this);
        }
    }
}