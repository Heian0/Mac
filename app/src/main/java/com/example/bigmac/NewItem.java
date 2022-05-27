package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewItem extends AppCompatActivity {

    private ActivityHandler activityHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        Button btnMacCalc = findViewById(R.id.btnMacCalc);
        btnMacCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                GoToMacCalc();
            }
        });
    }

    private void GoToMacCalc()
    {
        Intent intent = new Intent(this, MacCalc.class);
        startActivity(intent);
    }
}