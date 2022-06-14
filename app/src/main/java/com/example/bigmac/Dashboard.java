package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private ActivityHandler activityHandler;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        user = new User();
        user.ResetDailyMacros();

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
        startActivity(intent);
    }


    private void GoToTracker()
    {
        Intent intent = new Intent(this, Tracker.class);
        startActivity(intent);
    }

    public void UpdateDashboard()
    {
        TextView txtCalCount = findViewById(R.id.txtCalCount);

        txtCalCount.setText(user.userDailyMacrosDict.get("cal"));
    }

}