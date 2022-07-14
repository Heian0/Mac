package com.example.bigmac;

import android.content.Context;

import com.example.bigmac.Item;

//special button TrackerButton that is like an android button but contains an item, the item
//that is linked to that button
public class TrackerButton extends androidx.appcompat.widget.AppCompatButton
{
    public TrackerButton(Context context) {
        super(context);
    }

    private Item item;

    public void setItem(Item item) { this.item = item; }

    public Item getItem() { return item; }
}