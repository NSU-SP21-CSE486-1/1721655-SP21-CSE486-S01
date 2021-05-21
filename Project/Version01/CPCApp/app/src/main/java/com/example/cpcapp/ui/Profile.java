package com.example.cpcapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.SharedPrefManager;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.viewmodel.AppViewModel;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private String userEmail;
    private SharedPrefManager pref;
    private ArrayList<StudentInfoAPI> arrayList;
    private AppViewModel appViewModel;

    private String student_name;
    private String student_id;
    private String student_nsu_email;
    private String student_school;
    private String student_department;
    private String student_dob;
    private String student_phone;
    private String student_personal_email;
    private String student_nid;

    private String pres_country;
    private String pres_district;
    private String pres_post_office;
    private String pres_police_station;
    private String pres_postal_code;
    private String pres_hvc;
    private String pres_rbs;

    EditText mStudent_name,mStudent_id,mStudent_school,mStudent_department,mStudent_dob,mStudent_phone,
            mStudent_personal_email,mStudent_nid,mPres_country,mPres_district,mPres_post_office,mPres_police_station,mPres_postal_code,mPres_hvc,mPres_rbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);

        mStudent_name = findViewById(R.id.prof_full_name_editText);
        mStudent_id = findViewById(R.id.prof_nsu_id_editText);
        mStudent_school = findViewById(R.id.prof_school_editText);
        mStudent_department = findViewById(R.id.prof_department_editText);
        mStudent_dob = findViewById(R.id.prof_dob_editText);
        mStudent_phone = findViewById(R.id.prof_phone_editText);
        mStudent_personal_email = findViewById(R.id.prof_personal_email_editText);
        mStudent_nid = findViewById(R.id.prof_nid_editText);
        mPres_country = findViewById(R.id.prof_pres_country_editText);
        mPres_district = findViewById(R.id.prof_pres_district_editText);
        mPres_post_office = findViewById(R.id.prof_pres_post_editText);
        mPres_police_station = findViewById(R.id.prof_pres_police_station_editText);
        mPres_postal_code = findViewById(R.id.prof_pres_postal_code_editText);
        mPres_hvc = findViewById(R.id.prof_pres_hvc_editText);
        mPres_rbs = findViewById(R.id.prof_pres_rbs_editText);



        arrayList = new ArrayList<>();
        pref = new SharedPrefManager(Profile.this);
        userEmail = pref.getEmail();
        arrayList = appViewModel.getStudentData();
        getUser();

        mStudent_name.setText(student_name);
        mStudent_id.setText(student_id);
        mStudent_school.setText(student_school);
        mStudent_department.setText(student_department);
        mStudent_dob.setText(student_dob);
        mStudent_phone.setText(student_phone);
        mStudent_personal_email.setText(student_personal_email);
        mStudent_nid.setText(student_nid);
        mPres_country.setText(pres_country);
        mPres_district.setText(pres_district);
        mPres_post_office.setText(pres_post_office);
        mPres_police_station.setText(pres_police_station);
        mPres_postal_code.setText(pres_postal_code);
        mPres_hvc.setText(pres_hvc);
        mPres_rbs.setText(pres_rbs);

    }

    private void getUser() {
        for(StudentInfoAPI student : arrayList){
            if(student.getStudent_nsu_email().equals(userEmail)){

                student_name = student.getStudent_name();
                student_id = student.getStudent_id();
                student_nsu_email = student.getStudent_nsu_email();
                student_school = student.getStudent_school();
                student_department = student.getStudent_department();
                student_dob = student.getStudent_dob();
                student_phone = student.getStudent_phone();
                student_personal_email = student.getStudent_personal_email();
                student_nid = student.getStudent_nid();

                pres_country = student.getPres_country();
                pres_district = student.getPres_district();
                pres_post_office = student.getPres_post_office();
                pres_police_station = student.getPres_police_station();
                pres_postal_code = student.getPres_postal_code();
                pres_hvc = student.getPres_hvc();
                pres_rbs = student.getPres_rbs();

                break;
            }
        }
    }
    


    public void update(View view) {
        StudentInfoAPI studentInfo = new StudentInfoAPI();
        studentInfo.setStudent_name(mStudent_name.getText().toString());
        studentInfo.setStudent_id(mStudent_id.getText().toString());
        studentInfo.setStudent_nsu_email(student_nsu_email);
        studentInfo.setStudent_school(mStudent_school.getText().toString());
        studentInfo.setStudent_department(mStudent_department.getText().toString());
        studentInfo.setStudent_dob(mStudent_dob.getText().toString());
        studentInfo.setStudent_phone(mStudent_phone.getText().toString());
        studentInfo.setStudent_personal_email(mStudent_personal_email.getText().toString());
        studentInfo.setStudent_nid(mStudent_nid.getText().toString());
        studentInfo.setPres_country(mPres_country.getText().toString());
        studentInfo.setPres_district(mPres_district.getText().toString());
        studentInfo.setPres_post_office(mPres_post_office.getText().toString());
        studentInfo.setPres_police_station(mPres_police_station.getText().toString());
        studentInfo.setPres_postal_code(mPres_postal_code.getText().toString());
        studentInfo.setPres_hvc(mPres_hvc.getText().toString());
        studentInfo.setPres_rbs(mPres_rbs.getText().toString());

        appViewModel.insertStudent(studentInfo);

        Toast.makeText(getApplicationContext(),"Profile Updated.",Toast.LENGTH_SHORT).show();
    }
}