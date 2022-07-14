package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.SyncFailedException;

//activity for a user to input their own personalized meal macros
public class NewItem extends AppCompatActivity {

    private Button btnAddNewItem;
    private DictHandler dictHandler = new DictHandler();

    private Dashboard dashboard = new Dashboard();
    public static final String SHARED_PREFS = "savedItem";
    public static Item savedItem;

    //sets methods for buttons upon entering new item activity
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

        btnAddNewItem = findViewById(R.id.btnAddNewItem);
    }
    //changes activity to mac calc
    private void GoToMacCalc() {
        Intent intent = new Intent(this, MacCalc.class);
        startActivity(intent);
    }
    //adds a new item into the dictionary based on given parameters upon clicking new item button
    public void OnBtnAddNewItemClick(View view) throws IOException {
        EditText edtTxtItemName = findViewById(R.id.edtTxtItemName);
        EditText edtTxtItemCal = findViewById(R.id.edtTxtItemCal);
        EditText edtTxtItemPro = findViewById(R.id.edtTxtItemPro);
        EditText edtTxtItemFib = findViewById(R.id.edtTxtItemFib);
        EditText edtTxtItemSug = findViewById(R.id.edtTxtItemSug);
        EditText edtTxtItemSod = findViewById(R.id.edtTxtItemSod);
        EditText edtTxtItemCarb = findViewById(R.id.edtTxtItemCarb);

        if (edtTxtItemName.getText().toString().equals(""))
        {
            //change to a toast later
            System.out.println("please enter a name");
            return;
        }

        if(     (edtTxtIsDigOrBlank(edtTxtItemCal))
                && edtTxtIsDigOrBlank(edtTxtItemPro)
                && edtTxtIsDigOrBlank(edtTxtItemFib)
                && edtTxtIsDigOrBlank(edtTxtItemSug)
                && edtTxtIsDigOrBlank(edtTxtItemSod)
                && edtTxtIsDigOrBlank(edtTxtItemCarb)
        )
        {
            int cal, pro, fib, sug, sod, carb;

            if(!edtTxtItemCal.getText().toString().equals("")) { cal = Integer.valueOf(edtTxtItemCal.getText().toString()); }
            else { cal = -1; }

            if(!edtTxtItemPro.getText().toString().equals("")) { pro = Integer.valueOf(edtTxtItemPro.getText().toString()); }
            else { pro = -1; }

            if(!edtTxtItemFib.getText().toString().equals("")) { fib = Integer.valueOf(edtTxtItemFib.getText().toString()); }
            else { fib = -1; }

            if(!edtTxtItemSug.getText().toString().equals("")) { sug = Integer.valueOf(edtTxtItemSug.getText().toString()); }
            else { sug = -1; }

            if(!edtTxtItemSod.getText().toString().equals("")) { sod = Integer.valueOf(edtTxtItemSod.getText().toString()); }
            else { sod = -1; }

            if(!edtTxtItemCarb.getText().toString().equals("")) { carb = Integer.valueOf(edtTxtItemCarb.getText().toString()); }
            else { carb = -1; }

            Item newItem = new Item(edtTxtItemName.getText().toString(), cal, pro, fib, sug, sod, carb );
            dictHandler.addItemToDict(dictHandler.getTestDict(), newItem);
            SaveItem(newItem);
        }
    }
    //saves a custom item made by a user
    public void SaveItem(Item item)
    {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("name", item.getName());
        editor.putInt("cal", item.getCalories());
        editor.putInt("pro", item.getProtein());
        editor.putInt("fib", item.getFiber());
        editor.putInt("sod", item.getSodium());
        editor.putInt("sug", item.getSugar());
        editor.putInt("carb", item.getCarbs());

        editor.apply();
        Toast.makeText(this, "Item Saved", Toast.LENGTH_SHORT).show();
    }

    //get the custom item that was saved by user
    public void getSavedItem(SharedPreferences sp)
    {
        Item newItem = new Item(sp.getString("name", "none"),
                sp.getInt("cal", -1),
                sp.getInt("pro", -1),
                sp.getInt("fib", -1),
                sp.getInt("sod", -1),
                sp.getInt("sug", -1),
                sp.getInt("carb", -1));

        savedItem = newItem;

    }

    //checks if inputed string is either digits only/blank or if it contains any text
    private boolean edtTxtIsDigOrBlank(EditText edtTxt)
    {
        if(TextUtils.isDigitsOnly(edtTxt.getText().toString()) || edtTxt.getText().toString().equals("")) { return true;}
        else {return false;}
    }
}