package com.example.cpcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import com.example.cpcapp.ui.Home;
import com.example.cpcapp.ui.Registration;

public class MainActivity extends AppCompatActivity {
    private static int TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Registration.class);
                startActivity(intent);
                finish();
            }
        }, TIME);
    }
}