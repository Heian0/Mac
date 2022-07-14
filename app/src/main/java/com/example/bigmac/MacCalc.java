package com.example.bigmac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Spinner;
import android.text.TextUtils;

//MacCalc activity
public class MacCalc extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private Calculator calculator = new Calculator();
    private User user = new User();

    public static Context macCalcContext;

    /*
    private Toolbar toolbarMenu;

    private TabLayout tabLayoutMenu;
    private ViewPager viewPagerMenu;

    private NewUserFrag newUserFrag;
    private NewItemFrag newItemFrag;
    private MacCalcFrag macCalcFrag;
    private TrackerFrag trackerFrag;
    private DailyReportFrag dailyReportFrag;

     */

    //Sets the view of the activity and its ui input forms upon entering the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac_calc);


        Spinner spinnerGender = findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.sArrayGenders, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter((genderAdapter));
        spinnerGender.setOnItemSelectedListener(this);

        Spinner spinnerActivity = findViewById(R.id.spinnerActivity);
        ArrayAdapter<CharSequence> activityAdapter = ArrayAdapter.createFromResource(this, R.array.sArrayActivity, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter((activityAdapter));
        spinnerActivity.setOnItemSelectedListener(this);
    }



    //calculates maintencae calories based on given parameters and displays result
    public void OnBtnGetMCalClick(View view)
    {
        EditText edtTxtAge = findViewById(R.id.edtTxtAge);
        EditText edtTxtHeight = findViewById(R.id.edtTxtHeight);
        EditText edtTxtWeight = findViewById(R.id.edtTxtWeight);

        if (    TextUtils.isDigitsOnly(edtTxtAge.getText().toString())
                && TextUtils.isDigitsOnly(edtTxtHeight.getText().toString())
                && TextUtils.isDigitsOnly(edtTxtWeight.getText().toString())
                && (user.getGender() == 0 || user.getGender() == 1)
        )
        {
            int age = Integer.valueOf(edtTxtAge.getText().toString());
            int height = Integer.valueOf(edtTxtHeight.getText().toString());
            int weight = Integer.valueOf(edtTxtWeight.getText().toString());

            int mCal = calculator.CalculateMCal(age, height, weight, user.getGender(), user.getActivity());
            TextView txtMCal = findViewById(R.id.txtMCal);
            txtMCal.setText(Integer.toString(mCal));
        }

        else
        {
            return;
        }
    }

    //controls the selection of the Spinners (drop down menus)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (parent.getId())
        {
            case R.id.spinnerGender:
                if (position == 0) user.setGender(0);
                else user.setGender(1);;
                break;

            case R.id.spinnerActivity:
                switch(position)
                {
                    case 0: user.setActivity(0); break;
                    case 1: user.setActivity(1); break;
                    case 2: user.setActivity(2); break;
                    case 3: user.setActivity(3); break;
                    case 4: user.setActivity(4); break;
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}