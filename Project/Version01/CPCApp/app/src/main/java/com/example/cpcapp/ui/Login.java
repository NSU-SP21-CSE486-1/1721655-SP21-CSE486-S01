package com.example.cpcapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.AdminData;
import com.example.cpcapp.datasource.SharedPrefManager;
import com.example.cpcapp.viewmodel.AppViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private EditText nsuEmail,mPassword;
    private TextView mRegister;
    private AppViewModel appViewModel;
    private FirebaseAuth firebaseAuth;
    private SharedPrefManager pref;
    private ArrayList<AdminData> adminData;
    private boolean check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = new SharedPrefManager(Login.this);

        if(pref.checkAdmin()){
            startActivity(new Intent(Login.this,DashBoard.class));
            finish();
        }
        if(pref.checkLogin()) {
            startActivity(new Intent(Login.this, Home.class));
            finish();

        }
        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);



        adminData = appViewModel.getAdminData();



        nsuEmail = findViewById(R.id.log_nsu_email_editText);
        mPassword = findViewById(R.id.log_password_editText);
        mRegister = findViewById(R.id.log_register_textView);

        firebaseAuth = appViewModel.getAuthRef();

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();
            }
        });

    }

    public void LoginUser(View view) {

            for (AdminData adminData : adminData) {
                check = adminData.getEmail().equals(nsuEmail.getText().toString()) && adminData.getPassword().equals(mPassword.getText().toString());
                break;
            }
            if (check) {
                pref.adminLogin(nsuEmail.getText().toString(), mPassword.getText().toString());
                Toast.makeText(getApplicationContext(), "Login Successful!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DashBoard.class));
                finish();
            } else {
                firebaseAuth.signInWithEmailAndPassword(nsuEmail.getText().toString(), mPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    pref.userLogin(nsuEmail.getText().toString(), mPassword.getText().toString());
                                    Toast.makeText(getApplicationContext(), "Login Successful!!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), Home.class));
                                    finish();
                                }
                            }
                        });
             }
          }
        

}