package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_DATA_EMAIL = "com.example.android.studentsignupapp.extra.DATA";
    private String email = "student.nsu@northsouth.edu", password = "login12345",emailData;
    private EditText mEmail,mPassword;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.email_editText);
        mPassword = findViewById(R.id.password_editText);
        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(mEmail.getText().toString().trim().equals(email) && mPassword.getText().toString().trim().equals(password)){
                       launchSecondActivity();
                   }else
                       Toast.makeText(getApplicationContext(), "Email or Password is Incorrect!!!", Toast.LENGTH_LONG).show();

               }
           });


    }
    public void launchSecondActivity() {
        emailData = mEmail.getText().toString();
        Intent intent = new Intent(this, Vrification.class);
        intent.putExtra(EXTRA_DATA_EMAIL,emailData);
        startActivity(intent);
    }
}