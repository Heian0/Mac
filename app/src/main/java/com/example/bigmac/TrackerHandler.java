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

    //displays an item to the Tracker activity and sets on click methods for each tracker button
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

    //writes changes after an item has been eaten to the user's macro dictionary
    public void OnTrackerButtonClick(Item item)
    {
        if (item.getCalories() != -1)
        {user.userDailyMacrosDict.put("cal", user.userDailyMacrosDict.get("cal") + item.getCalories());}

        if (item.getProtein() != -1)
        {user.userDailyMacrosDict.put("pro", user.userDailyMacrosDict.get("pro") + item.getProtein());}

        if (item.getFiber() != -1)
        {user.userDailyMacrosDict.put("fib", user.userDailyMacrosDict.get("fib") + item.getFiber());}

        if (item.getSodium() != -1)
        {user.userDailyMacrosDict.put("sod", user.userDailyMacrosDict.get("sod") + item.getSugar());}

        if (item.getSugar() != -1)
        {user.userDailyMacrosDict.put("sug", user.userDailyMacrosDict.get("sug") + item.getSodium());}

        if (item.getCarbs() != -1)
        {user.userDailyMacrosDict.put("carb", user.userDailyMacrosDict.get("carb") + item.getCarbs());}

        //displays new macros to dashboard
        dashboard.txtCalCount.setText(user.userDailyMacrosDict.get("cal").toString());
        dashboard.txtProCount.setText(user.userDailyMacrosDict.get("pro").toString());
        dashboard.txtFibCount.setText(user.userDailyMacrosDict.get("fib").toString());
        dashboard.txtSodCount.setText(user.userDailyMacrosDict.get("sod").toString());
        dashboard.txtSugCount.setText(user.userDailyMacrosDict.get("sug").toString());
        dashboard.txtCarbCount.setText(user.userDailyMacrosDict.get("carb").toString());
    }
}