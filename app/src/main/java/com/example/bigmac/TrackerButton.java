package com.example.bigmac;

import android.content.Context;

import com.example.bigmac.Item;

public class TrackerButton extends androidx.appcompat.widget.AppCompatButton
{
    public TrackerButton(Context context) {
        super(context);
    }

    private Item item;

    public void setItem(Item item) { this.item = item; }

    public Item getItem() { return item; }
}