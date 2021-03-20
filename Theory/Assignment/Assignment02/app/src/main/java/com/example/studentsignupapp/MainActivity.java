package com.example.studentsignupapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.hbb20.CountryCodePicker;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner schoolSpinner;
    private Spinner departmentSpinner ;
    private ArrayAdapter<String> arrayAdapterDepartments;
    private ArrayAdapter<String> arrayAdapterSchool;
    private EditText dateOfBirth,phoneNumber,NID;
    private String strSchool,strDepartment,strDoB,strPhoneNumber,strNID;
    private CountryCodePicker ccp;
    private Button submit,next;

    public static final String EXTRA_MESSAGE = "com.example.android.studentsignupapp.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--------------------------------CODE FOR BUTTONS------------------------------------------
        submit = (Button)findViewById(R.id.button_submit);
        next = (Button)findViewById(R.id.button_next);
        //-------------------------------------END--------------------------------------------------

        //------------------------------SPINNER CODE FOR SCHOOL-------------------------------------
        schoolSpinner = (Spinner) findViewById(R.id.school_spinner);
        schoolSpinner.setOnItemSelectedListener(this);
        departmentSpinner = (Spinner) findViewById(R.id.department_spinner);
        final String[] school = getResources().getStringArray(R.array.school_names);
        arrayAdapterSchool =  new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,school);
        arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(arrayAdapterSchool);
        strSchool = arrayAdapterSchool.toString();
        //-------------------------------------END--------------------------------------------------

        //--------------------------------CODE FOR DATE OF BIRTH------------------------------------
        dateOfBirth = findViewById(R.id.dob_editText);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateOfBirth.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        dateOfBirth.setText(date);
                    }
                },year,month,day);
                datePicker.show();
                strDoB = datePicker.toString();
            }

        });
        //------------------------------------------END---------------------------------------------

        //---------------------------------CODE FOR PHONE NUMBER------------------------------------
        ccp = (CountryCodePicker) findViewById(R.id.picker);
        phoneNumber = (EditText) findViewById(R.id.phone_number_editText);
        strPhoneNumber = ccp.toString() + phoneNumber.toString();
        //-----------------------------------------END----------------------------------------------

        //---------------------------------CODE FOR NID NUMBER--------------------------------------
        NID = findViewById(R.id.nid_number_editText);
        strNID = NID.toString();
        //------------------------------------------END---------------------------------------------
    }


    //---------------------------------SPINNER CODE FOR DEPARTMENTS---------------------------------
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            final String[] sbeDepartments = getResources().getStringArray(R.array.sbe_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sbeDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }else
        if(position == 1){
            final String[] sepDepartments = getResources().getStringArray(R.array.sep_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sepDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);

        }else
        if(position == 2){
            final String[] shlDepartments = getResources().getStringArray(R.array.shl_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shlDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);

        }else
        if(position == 3){
            final String[] shsDepartments = getResources().getStringArray(R.array.shs_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shsDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }

        strDepartment = arrayAdapterDepartments.toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    //----------------------------------------------END---------------------------------------------



    //-------------------------------CODE TO START ADDRESS ACTIVITY---------------------------------
    public void launchSecondActivity(View view) {
        Intent addressIntent = new Intent(this, Address.class);
        startActivityForResult(addressIntent, TEXT_REQUEST);
    }
    //-------------------------------------------END------------------------------------------------



    //--------------------------------CODE FOR INTENT RESULT----------------------------------------
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                //----------------------------------PRESENT ADDRESS---------------------------------
                String reply1 = data.getStringExtra(Address.EXTRA_REPLY_1);
                String reply2 = data.getStringExtra(Address.EXTRA_REPLY_2);
                String reply3 = data.getStringExtra(Address.EXTRA_REPLY_3);
                String reply4 = data.getStringExtra(Address.EXTRA_REPLY_4);
                String reply5 = data.getStringExtra(Address.EXTRA_REPLY_5);
                String reply6 = data.getStringExtra(Address.EXTRA_REPLY_6);
                String reply7 = data.getStringExtra(Address.EXTRA_REPLY_7);
                //---------------------------------------END----------------------------------------

                //-----------------------------------PERMANENT ADDRESS------------------------------
                String reply8 = data.getStringExtra(Address.EXTRA_REPLY_8);
                String reply9 = data.getStringExtra(Address.EXTRA_REPLY_9);
                String reply10 = data.getStringExtra(Address.EXTRA_REPLY_10);
                String reply11 = data.getStringExtra(Address.EXTRA_REPLY_11);
                String reply12 = data.getStringExtra(Address.EXTRA_REPLY_12);
                String reply13 = data.getStringExtra(Address.EXTRA_REPLY_13);
                String reply14 = data.getStringExtra(Address.EXTRA_REPLY_14);
                //---------------------------------------END----------------------------------------
            }
        }
    }
    //-------------------------------------------END------------------------------------------------
}