package com.example.studentsignupappv2.uicontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private static final String TAG = Register.class.getSimpleName() ;
    private FirebaseAuth mAuth;
    private StudentViewModel viewModel;
    private EditText mEmail,mPassword;
    private String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        viewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        viewModel.regInit();
        mAuth = viewModel.userRegister();
        mEmail = findViewById(R.id.student_email_editText_register);
        mPassword = findViewById(R.id.student_password_editText_register);

    }

    public void register(View view){
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(Register.this, task -> {
                    if(task.isSuccessful()){
                        //Toast.makeText(Register.this,"Registration Complete",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }else
                        Toast.makeText(Register.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                });

    }
}