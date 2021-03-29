package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Vrification extends AppCompatActivity {
private TextView mEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrification);
        mEmail = findViewById(R.id.email_textView2);
        Intent intent = getIntent();
        String emailData = intent.getStringExtra(MainActivity.EXTRA_DATA_EMAIL);
        mEmail.setText(emailData);
    }


}