package com.example.studentsignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner schoolSpinner;
    private Spinner departmentSpinner ;
    private ArrayAdapter<CharSequence> arrayAdapterDepartments;
    private ArrayAdapter<CharSequence> arrayAdapterSchool;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schoolSpinner = (Spinner) findViewById(R.id.school_spinner);
        departmentSpinner = (Spinner) findViewById(R.id.department_spinner);
        String[] school = getResources().getStringArray(R.array.school_names);
        arrayAdapterSchool =  new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,school);
        arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        schoolSpinner.setAdapter(arrayAdapterSchool);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            String[] sbeDepartments = getResources().getStringArray(R.array.sbe_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sbeDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }
        if(position == 1){
            String[] sepDepartments = getResources().getStringArray(R.array.sep_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sepDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }
        if(position == 2){
            String[] shlDepartments = getResources().getStringArray(R.array.shl_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shlDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }
        if(position == 3){
            String[] shsDepartments = getResources().getStringArray(R.array.shs_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shsDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}