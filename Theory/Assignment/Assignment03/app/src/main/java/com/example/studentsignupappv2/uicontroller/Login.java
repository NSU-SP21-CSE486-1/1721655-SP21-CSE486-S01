package com.example.studentsignupappv2.uicontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.datascource.SharedPrefManager;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;
import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText mEmail,mPassword;
    private String email,password;
    private StudentViewModel viewModel;
    private FirebaseAuth fireAuth;
    private static final String TAG = Login.class.getSimpleName() ;
    SharedPrefManager pref;
    private Button langButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_login);
        pref = new SharedPrefManager(Login.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.login_button));

        //---------------------------------CODE FOR LANGUAGE BUTTONS--------------------------------
        langButton = findViewById(R.id.button_language_login);
        langButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguageSelectDialog();
            }
        });
        //----------------------------------------END-----------------------------------------------

        if(pref.checkLogin()){
            startActivity(new Intent(Login.this,StudentForm.class));
            finish();
        }

        viewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        viewModel.regInit();
        fireAuth = viewModel.userRegister();
        mEmail = findViewById(R.id.student_email_editText);
        mPassword = findViewById(R.id.student_password_editText);

    }


    public void login(View view){
        pref.userLogin(mEmail.getText().toString(),mPassword.getText().toString());
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();
        fireAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(Login.this, task -> {
                  if(task.isSuccessful()){
                      startActivity(new Intent(Login.this,StudentForm.class));
                      finish();
                  }else
                      Toast.makeText(Login.this,"Login Failed!!!", Toast.LENGTH_SHORT).show();
                });
    }

    public void regIntent(View view){
        startActivity(new Intent(Login.this,Register.class));
    }

    //-----------------------------------CODE FOR LANGUAGE SETTINGS---------------------------------
    private void showLanguageSelectDialog() {
        final String[] listItems = {getResources().getString(R.string.english),getResources().getString(R.string.bangla)};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Login.this);
        mBuilder.setTitle(R.string.select_language);
        mBuilder.setSingleChoiceItems(listItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i == 0){
                    setLocale("en");
                    recreate();
                }
                else if(i == 1){
                    setLocale("bn");
                    recreate();
                }
                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();


    }


    private void setLocale(String s) {
        Locale locale = new Locale(s);
        Locale.setDefault(locale);
        Configuration config =  new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("App_Lang",s);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("App_Lang","");
        setLocale(language);
    }
    //-------------------------------------------END------------------------------------------------
}