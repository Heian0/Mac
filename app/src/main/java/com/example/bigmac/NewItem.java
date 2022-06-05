package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.SyncFailedException;

public class NewItem extends AppCompatActivity {

    private Button btnAddNewItem;
    private DictHandler dictHandler = new DictHandler();
    private TrackerHandler trackerHandler = new TrackerHandler();

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

    private void GoToMacCalc()
    {
        Intent intent = new Intent(this, MacCalc.class);
        startActivity(intent);
    }

    public void OnBtnAddNewItemClick(View view)
    {
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
        }
    }

    private boolean edtTxtIsDigOrBlank(EditText edtTxt)
    {
        if(TextUtils.isDigitsOnly(edtTxt.getText().toString()) || edtTxt.getText().toString().equals("")) { return true;}
        else {return false;}
    }
}