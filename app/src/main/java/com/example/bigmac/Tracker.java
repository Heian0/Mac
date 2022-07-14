package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Set;
import java.util.Hashtable;

//Tracker activity
public class Tracker extends AppCompatActivity {

    private TrackerHandler trackerHandler = new TrackerHandler();
    private DictHandler dictHandler = new DictHandler();
    private NewItem newItem = new NewItem();

    //displays all items stored as button so that user can click a button to track they have eaten
    //that item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        ViewGroup trackerVG = (ViewGroup) findViewById(R.id.trackerVG);

        SharedPreferences sp = getSharedPreferences(NewItem.SHARED_PREFS, NewItem.MODE_PRIVATE);
        newItem.getSavedItem(sp);
        dictHandler.addItemToDict(dictHandler.getTestDict(), newItem.savedItem);
        for (String key : dictHandler.testDict.keySet())
        {
            trackerHandler.displayNewItem(dictHandler.testDict.get(key), trackerVG, this);
        }
    }
}