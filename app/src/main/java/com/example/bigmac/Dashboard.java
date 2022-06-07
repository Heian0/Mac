package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    private ActivityHandler activityHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnMacCalc = findViewById(R.id.btnMacCalc);
        btnMacCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                GoToMacCalc();
            }
        });

        Button btnTracker = findViewById(R.id.btnTracker);
        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                GoToTracker();
            }
        });
    }


    private void GoToMacCalc()
    {
        Intent intent = new Intent(this, MacCalc.class);
        System.out.println(this);
        startActivity(intent);
    }


    private void GoToTracker()
    {
        Intent intent = new Intent(this, Tracker.class);
        System.out.println(this);
        startActivity(intent);
    }
}