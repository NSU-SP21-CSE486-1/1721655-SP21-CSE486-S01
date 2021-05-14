package com.example.cpcapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Registration extends AppCompatActivity {

    private EditText regFullName, regNsuId, regNsuEmail, regDob, regNid, regPassword;
    private Button regSubmitButton;
    private AppViewModel appViewModel;
    private boolean check;
    private FirebaseAuth firebaseAuth;
    private ArrayList<StudentInfoAPI> arrayList = new ArrayList<>();


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
        firebaseAuth = appViewModel.getAuthRef();


    }


   public void checkData(){

    arrayList = appViewModel.getStudentData();

   }







    public void Register(View view) {
        //regFullName.getText().toString(),regNsuId.getText().toString(),regNsuEmail.getText().toString(),regDob.getText().toString(),regNid.getText().toString()
        checkData();
        if (arrayList.isEmpty()) {
            Toast.makeText(getApplicationContext(), "TRY AGAIN!!!", Toast.LENGTH_SHORT).show();
        } else {
            for (StudentInfoAPI student : arrayList) {
                check = student.getStudent_id().equals(regNsuId.getText().toString());
            }

            if (check) {
                   firebaseAuth.createUserWithEmailAndPassword(regNsuEmail.getText().toString(), regPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull  Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(getApplicationContext(), "Registration Successful!!", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(getApplicationContext(), Login.class));
                               finish();
                           } else {
                               Toast.makeText(Registration.this, "Registration Error!!", Toast.LENGTH_SHORT).show();
                           }

                       }
                   });

                }
             else {
                Toast.makeText(Registration.this, "You are not valid for registration!!", Toast.LENGTH_SHORT).show();
            }


        }

    }
}