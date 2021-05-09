package com.example.cpcapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cpcapp.R;

public class Registration extends AppCompatActivity {

    EditText regFullName,regNsuId,regNsuEmail,regDob,regNid;
    Button regSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regFullName = findViewById(R.id.reg_full_name_editText);
        regNsuId = findViewById(R.id.reg_nsu_id_editText);
        regNsuEmail = findViewById(R.id.reg_nsu_email_editText);
        regDob = findViewById(R.id.reg_dob_editText);
        regNid = findViewById(R.id.reg_nid_editText);

        regSubmitButton = findViewById(R.id.reg_submit_button);
    }

    public void Register(View view) {

    }
}