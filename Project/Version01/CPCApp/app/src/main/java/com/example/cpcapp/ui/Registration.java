package com.example.cpcapp.ui;

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

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.repository.AppRepository;
import com.example.cpcapp.viewmodel.AppViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Registration extends AppCompatActivity {

    private EditText regFullName, regNsuId, regNsuEmail, regDob, regNid, regPassword;
    private Button regSubmitButton;
    private AppViewModel appViewModel;
    private boolean check= false;
    private String tag = AppRepository.class.getSimpleName(),value;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);

        regFullName = findViewById(R.id.reg_full_name_editText);
        regNsuId = findViewById(R.id.reg_nsu_id_editText);
        regNsuEmail = findViewById(R.id.reg_nsu_email_editText);
        regDob = findViewById(R.id.reg_dob_editText);
        regNid = findViewById(R.id.reg_nid_editText);
        regPassword = findViewById(R.id.reg_password_editText);

        regSubmitButton = findViewById(R.id.reg_submit_button);
        dbRef = appViewModel.getDbRef();


    }

    public void Register(View view) {
        //regFullName.getText().toString(),regNsuId.getText().toString(),regNsuEmail.getText().toString(),regDob.getText().toString(),regNid.getText().toString()

        dbRef.child(regNsuId.getText().toString()).child("student_id").get()
                .addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(Objects.requireNonNull(task.getResult()).exists()){
                     DataSnapshot dataSnapshot = task.getResult();
                     value = String.valueOf(dataSnapshot.getValue());
                     Log.d(tag,value);
                    }
                }
            }
        });


       /* if(value.equals(regNsuId.getText().toString())){
            check = true;
        }
        else{
            check = false;
        }*/


            if (check) {
                if (appViewModel.registerStudent(regNsuEmail.getText().toString(), regPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Registration Successful!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                } else {
                    Toast.makeText(Registration.this, "Registration Error!!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Registration.this, "You are not valid for registration!!", Toast.LENGTH_SHORT).show();
            }


    }
}