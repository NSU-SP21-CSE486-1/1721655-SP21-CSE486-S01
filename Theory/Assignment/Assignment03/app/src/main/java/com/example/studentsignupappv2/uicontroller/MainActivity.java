package com.example.studentsignupappv2.uicontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentsignupappv2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentForm();

    }

    public void StudentForm(){
        Intent intent = new Intent(this,StudentForm.class);
        startActivity(intent);
        finish();
    }
}