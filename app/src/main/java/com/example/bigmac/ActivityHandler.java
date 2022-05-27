package com.example.bigmac;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import javax.crypto.Mac;

public class ActivityHandler
{
    public void OpenActivity(Context context, int newActivityIndex)
    {
        Intent intent;

        switch (newActivityIndex)
        {
            case 0:

                intent = new Intent(context, NewItem.class);
                context.startActivity(intent);

                break;

            case 2:

                intent = new Intent(context, MacCalc.class);
                context.startActivity(intent);

                break;
        }
    }

    public void GoToMacCalc(Context context)
    {
        Intent intent = new Intent(context, MacCalc.class);
        context.startActivity(intent);
    }
}
