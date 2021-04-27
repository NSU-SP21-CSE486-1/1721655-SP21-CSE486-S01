package com.example.studentsignupappv2.uicontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText mEmail,mPassword;
    private String email,password;
    private StudentViewModel viewModel;
    private FirebaseAuth fireAuth;
    private static final String TAG = Login.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        viewModel.regInit();
        fireAuth = /*viewModel.userRegister();*/FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.student_email_editText);
        mPassword = findViewById(R.id.student_password_editText);





    }

    public void login(View view){
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();
        fireAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(Login.this, task -> {
                  if(task.isSuccessful()){
                      startActivity(new Intent(Login.this,StudentForm.class));
                  }else
                      Toast.makeText(Login.this,"Login Failed!!!", Toast.LENGTH_SHORT).show();
                });
    }

    public void regIntent(View view){
        startActivity(new Intent(Login.this,Register.class));
    }
}