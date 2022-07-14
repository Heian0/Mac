package com.example.bigmac;

import static android.provider.Telephony.Mms.Part.NAME;
import static android.provider.Telephony.Mms.Part.TEXT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    public static User user;
    public static TextView txtCalCount;
    public static TextView txtProCount;
    public static TextView txtFibCount;
    public static TextView txtSodCount;
    public static TextView txtSugCount;
    public static TextView txtCarbCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        user = new User();
        user.setDailyMacros();

        txtCalCount = findViewById(R.id.txtCalCount);
        txtProCount = findViewById(R.id.txtProCount);
        txtFibCount = findViewById(R.id.txtFibCount);
        txtSodCount = findViewById(R.id.txtSodCount);
        txtSugCount = findViewById(R.id.txtSugCount);
        txtCarbCount = findViewById(R.id.txtCarbCount);

        //sets the on click method for btnMacCalc
        Button btnMacCalc = findViewById(R.id.btnMacCalc);
        btnMacCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                GoToMacCalc();
            }
        });

        //sets the on click method for btnTracker
        Button btnTracker = findViewById(R.id.btnTracker);
        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                GoToTracker();
            }
        });

        //sets the on click method for btnNewItem
        Button btnNewItem = findViewById(R.id.btnNewItem);
        btnNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToNewItem();
            }
        });
    }

    //redirects to new item activity
    private void GoToNewItem()
    {
        Intent intent = new Intent(this, NewItem.class);
        startActivity(intent);
    }
    //Opens the MacCalc activity
    private void GoToMacCalc()
    {
        Intent intent = new Intent(this, MacCalc.class);
        startActivity(intent);
    }

    //Opens the Tracker activity
    private void GoToTracker()
    {
        Intent intent = new Intent(this, Tracker.class);
        startActivity(intent);
    }

}