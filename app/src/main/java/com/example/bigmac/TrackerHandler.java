package com.example.bigmac;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TrackerHandler
{
    public void displayNewItem(Item item, ViewGroup trackerLayout, Context context)
    {
        Button btnDisplayNewItem = new Button(context);
        btnDisplayNewItem.setText(item.getName());
        btnDisplayNewItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        trackerLayout.addView(btnDisplayNewItem);
    }
}