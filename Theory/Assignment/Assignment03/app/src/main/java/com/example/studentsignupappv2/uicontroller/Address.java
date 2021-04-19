package com.example.studentsignupappv2.uicontroller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.studentsignupappv2.R;

public class Address extends AppCompatActivity {

    public static final String EXTRA_REPLY_1 = "com.example.android.studentsignupapp.extra.REPLY_1";
    public static final String EXTRA_REPLY_2 = "com.example.android.studentsignupapp.extra.REPLY_2";
    public static final String EXTRA_REPLY_3 = "com.example.android.studentsignupapp.extra.REPLY_3";
    public static final String EXTRA_REPLY_4 = "com.example.android.studentsignupapp.extra.REPLY_4";
    public static final String EXTRA_REPLY_5 = "com.example.android.studentsignupapp.extra.REPLY_5";
    public static final String EXTRA_REPLY_6 = "com.example.android.studentsignupapp.extra.REPLY_6";
    public static final String EXTRA_REPLY_7 = "com.example.android.studentsignupapp.extra.REPLY_7";
    public static final String EXTRA_REPLY_8 = "com.example.android.studentsignupapp.extra.REPLY_8";
    public static final String EXTRA_REPLY_9 = "com.example.android.studentsignupapp.extra.REPLY_9";
    public static final String EXTRA_REPLY_10 = "com.example.android.studentsignupapp.extra.REPLY_10";
    public static final String EXTRA_REPLY_11 = "com.example.android.studentsignupapp.extra.REPLY_11";
    public static final String EXTRA_REPLY_12 = "com.example.android.studentsignupapp.extra.REPLY_12";
    public static final String EXTRA_REPLY_13 = "com.example.android.studentsignupapp.extra.REPLY_13";
    public static final String EXTRA_REPLY_14 = "com.example.android.studentsignupapp.extra.REPLY_14";

    private EditText mPermCountry,mPermDistrict,mPermPostOffice,mPermPoliceStation,mPermPostalCode,mPermHVC,mPermRBS;
    private EditText mPresCountry,mPresDistrict,mPresPostOffice,mPresPoliceStation,mPresPostalCode,mPresHVC,mPresRBS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.label_address));
        //----------------------------------PRESENT ADDRESS-----------------------------------------
        mPresCountry = findViewById(R.id.country_name_editText);
        mPresDistrict = findViewById(R.id.district_name_editText);
        mPresPostOffice = findViewById(R.id.post_office_editText);
        mPresPoliceStation = findViewById(R.id.police_station_editText);
        mPresPostalCode = findViewById(R.id.postal_code_editText);
        mPresHVC = findViewById(R.id.hvc_editText);
        mPresRBS = findViewById(R.id.rbs_editText);
        //---------------------------------------END------------------------------------------------

        //----------------------------------PERMANENT ADDRESS---------------------------------------
        mPermCountry = findViewById(R.id.country_name_editText_2);
        mPermDistrict = findViewById(R.id.district_name_editText_2);
        mPermPostOffice = findViewById(R.id.post_office_editText_2);
        mPermPoliceStation = findViewById(R.id.police_station_editText_2);
        mPermPostalCode = findViewById(R.id.postal_code_editText_2);
        mPermHVC = findViewById(R.id.hvc_editText_2);
        mPermRBS = findViewById(R.id.rbs_editText_2);
        //---------------------------------------END------------------------------------------------



        //------------------------CODE FOR SETTING SAVED INSTANCE-----------------------------------
        if (savedInstanceState != null) {
            //----------------------------PRESENT ADDRESS-------------------------------------------
            mPresCountry.setText(savedInstanceState.getString("reply_text1"));
            mPresDistrict.setText(savedInstanceState.getString("reply_text2"));
            mPresPostOffice.setText(savedInstanceState.getString("reply_text3"));
            mPresPoliceStation.setText(savedInstanceState.getString("reply_text4"));
            mPresPostalCode.setText(savedInstanceState.getString("reply_text5"));
            mPresHVC.setText(savedInstanceState.getString("reply_text6"));
            mPresRBS.setText(savedInstanceState.getString("reply_text7"));
            //---------------------------------END--------------------------------------------------

            //----------------------------PERMANENT ADDRESS-----------------------------------------
            mPermCountry.setText(savedInstanceState.getString("reply_text8"));
            mPermDistrict.setText(savedInstanceState.getString("reply_text9"));
            mPermPostOffice.setText(savedInstanceState.getString("reply_text10"));
            mPermPoliceStation.setText(savedInstanceState.getString("reply_text11"));
            mPermPostalCode.setText(savedInstanceState.getString("reply_text12"));
            mPermHVC.setText(savedInstanceState.getString("reply_text13"));
            mPermRBS.setText(savedInstanceState.getString("reply_text14"));
            //------------------------------------END-----------------------------------------------
        }
        //---------------------------------------END------------------------------------------------

    }


    //--------------------------------CODE FOR INTENT TO RETURN DATA--------------------------------
    public void returnReply(View view) {
        Intent replyIntent = new Intent();
        //----------------------------------PRESENT ADDRESS-----------------------------------------
        String reply1 = mPresCountry.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_1, reply1);
        String reply2 = mPresDistrict.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_2, reply2);
        String reply3 = mPresPostOffice.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_3, reply3);
        String reply4 = mPresPoliceStation.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_4, reply4);
        String reply5 = mPresPostalCode.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_5, reply5);
        String reply6 = mPresHVC.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_6, reply6);
        String reply7 = mPresRBS.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_7, reply7);
        //---------------------------------------END------------------------------------------------

        //-----------------------------------PERMANENT ADDRESS--------------------------------------
        String reply8 = mPermCountry.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_8, reply8);
        String reply9 = mPermDistrict.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_9, reply9);
        String reply10 = mPermPostOffice.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_10, reply10);
        String reply11 = mPermPoliceStation.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_11, reply11);
        String reply12 = mPermPostalCode.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_12, reply12);
        String reply13 = mPermHVC.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_13, reply13);
        String reply14 = mPermRBS.getText().toString();
        replyIntent.putExtra(EXTRA_REPLY_14, reply14);
        //---------------------------------------END------------------------------------------------
        setResult(RESULT_OK,replyIntent);
        finish();
    }
    //--------------------------------------------END-----------------------------------------------



    //----------------------------------CODE FOR SAVED INSTANCE-------------------------------------
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //------------------------------------PRESENT ADDRESS---------------------------------------
        outState.putString("reply_text1",mPresCountry.getText().toString());
        outState.putString("reply_text2",mPresDistrict.getText().toString());
        outState.putString("reply_text3",mPresPostOffice.getText().toString());
        outState.putString("reply_text4",mPresPoliceStation.getText().toString());
        outState.putString("reply_text5",mPresPostalCode.getText().toString());
        outState.putString("reply_text6",mPresHVC.getText().toString());
        outState.putString("reply_text7",mPresRBS.getText().toString());
        //-----------------------------------------END----------------------------------------------

        //-----------------------------------PERMANENT ADDRESS--------------------------------------
        outState.putString("reply_text8",mPermCountry.getText().toString());
        outState.putString("reply_text9",mPermDistrict.getText().toString());
        outState.putString("reply_text10",mPermPostOffice.getText().toString());
        outState.putString("reply_text11",mPermPoliceStation.getText().toString());
        outState.putString("reply_text12",mPermPostalCode.getText().toString());
        outState.putString("reply_text13",mPermHVC.getText().toString());
        outState.putString("reply_text14",mPermRBS.getText().toString());
        //-----------------------------------------END----------------------------------------------

    }
    //---------------------------------------------END----------------------------------------------

}