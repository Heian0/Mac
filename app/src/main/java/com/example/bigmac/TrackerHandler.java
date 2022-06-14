package com.example.bigmac;

import static com.example.bigmac.Dashboard.user;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TrackerHandler
{
    private Dashboard dashboard = new Dashboard();

    public void displayNewItem(Item item, ViewGroup trackerLayout, Context context)
    {
        TrackerButton btnTrackerButton = new TrackerButton(context);
        btnTrackerButton.setItem(item);
        btnTrackerButton.setText(item.getName());
        btnTrackerButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        btnTrackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                OnTrackerButtonClick(btnTrackerButton.getItem());
            }
        });

        trackerLayout.addView(btnTrackerButton);
    }

    public void OnTrackerButtonClick(Item item)
    {
        if (item.getCalories() != -1)
        {user.userDailyMacrosDict.put("cal", user.userDailyMacrosDict.get("cal") + item.getCalories());}

        if (item.getProtein() != -1)
        {user.userDailyMacrosDict.put("pro", user.userDailyMacrosDict.get("pro") + item.getProtein());}

        if (item.getFiber() != -1)
        {user.userDailyMacrosDict.put("fin", user.userDailyMacrosDict.get("fib") + item.getFiber());}

        if (item.getSodium() != -1)
        {user.userDailyMacrosDict.put("sug", user.userDailyMacrosDict.get("sod") + item.getSugar());}

        if (item.getSugar() != -1)
        {user.userDailyMacrosDict.put("sod", user.userDailyMacrosDict.get("sug") + item.getSodium());}

        if (item.getCarbs() != -1)
        {user.userDailyMacrosDict.put("carb", user.userDailyMacrosDict.get("carb") + item.getCarbs());}

        dashboard.UpdateDashboard();
    }
}