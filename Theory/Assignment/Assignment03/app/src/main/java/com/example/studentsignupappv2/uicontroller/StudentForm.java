package com.example.studentsignupappv2.uicontroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.datascource.SharedPrefManager;
import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class StudentForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner schoolSpinner;
    private Spinner departmentSpinner ;
    private ArrayAdapter<String> arrayAdapterDepartments;
    private ArrayAdapter<String> arrayAdapterSchool;
    private EditText studentName,studentID,dateOfBirth,phoneNumber,NID;
    private String strStudentName,strStudentId,strSchool,strDepartment,strDoB,strPhoneNumber,strNID;
    private String mPresCountry,mPresDistrict,mPresPostOffice,mPresPoliceStation,mPresPostalCode,mPresHVC,mPresRBS;
    private String mPermCountry,mPermDistrict,mPermPostOffice,mPermPoliceStation,mPermPostalCode,mPermHVC,mPermRBS;
    private Button submit,next;
    private TextView cc;
    private Button langButton;
    public static final int TEXT_REQUEST = 1;
    private StudentViewModel studentViewModel;
    private SharedPrefManager pref;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_student_form);


        pref = new SharedPrefManager(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        //---------------------------------CODE FOR LANGUAGE BUTTONS--------------------------------
        langButton = findViewById(R.id.button_lang);
        langButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguageSelectDialog();
            }
        });
        //----------------------------------------END-----------------------------------------------

        //----------------------------CODE FOR STUDENT NAME & ID------------------------------------
        studentName = findViewById(R.id.student_name_editText);
        studentID = findViewById(R.id.student_id_editText);
        //----------------------------------------END-----------------------------------------------

        //------------------------------SPINNER CODE FOR SCHOOL-------------------------------------
        schoolSpinner = findViewById(R.id.school_spinner);
        schoolSpinner.setOnItemSelectedListener(this);
        departmentSpinner = findViewById(R.id.department_spinner);
        final String[] school = getResources().getStringArray(R.array.school_names);
        arrayAdapterSchool =  new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,school);
        arrayAdapterSchool.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(arrayAdapterSchool);
        //-------------------------------------END--------------------------------------------------

        //--------------------------------CODE FOR DATE OF BIRTH------------------------------------
        dateOfBirth = findViewById(R.id.dob_editText);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateOfBirth.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                DatePickerDialog datePicker = new DatePickerDialog(StudentForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        strDoB = date;
                        dateOfBirth.setText(date);
                    }
                },year,month,day);
                datePicker.show();
            }

        });

        //------------------------------------------END---------------------------------------------

        //---------------------------------CODE FOR PHONE NUMBER------------------------------------
        cc = findViewById(R.id.country_code);
        phoneNumber = findViewById(R.id.phone_number_editText);
        //-----------------------------------------END----------------------------------------------

        //---------------------------------CODE FOR NID NUMBER--------------------------------------
        NID = findViewById(R.id.nid_number_editText);
        //------------------------------------------END---------------------------------------------

        //--------------------------------CODE FOR BUTTONS------------------------------------------
        submit = findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                strStudentId = studentID.getText().toString();
                strStudentName = studentName.getText().toString();
                strDepartment = departmentSpinner.getSelectedItem().toString();
                strPhoneNumber = cc.getText().toString() + phoneNumber.getText().toString();
                strNID = NID.getText().toString();
                saveData();
                pref.setDataForm("","","","","");
                pref.setSchoolSpinner(0);
                pref.setDepartmentSpinner(0);
            }
        });
        next = findViewById(R.id.button_next);
        //-------------------------------------END--------------------------------------------------

        //--------------------------------Student ViewModel-----------------------------------------
        studentViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        //-------------------------------------END--------------------------------------------------


        //----------------------CODE FOR SETTING SAVED INSTANCE STATE-------------------------------
        if(savedInstanceState != null){
            //------------------------------FORM DATA-----------------------------------------------
            studentName.setText(savedInstanceState.getString("reply1"));
            studentID.setText(savedInstanceState.getString("reply2"));
            strSchool = savedInstanceState.getString("reply3");
            strDepartment = savedInstanceState.getString("reply4");
            dateOfBirth.setText(savedInstanceState.getString("reply5"));
            phoneNumber.setText(savedInstanceState.getString("reply6"));
            NID.setText(savedInstanceState.getString("reply7"));
            //----------------------------------END-------------------------------------------------

            //------------------------------PRESENT ADDRESS-----------------------------------------
            mPresCountry = savedInstanceState.getString("reply_text1");
            mPresDistrict = savedInstanceState.getString("reply_text2");
            mPresPostOffice = savedInstanceState.getString("reply_text3");
            mPresPoliceStation = savedInstanceState.getString("reply_text4");
            mPresPostalCode = savedInstanceState.getString("reply_text5");
            mPresHVC = savedInstanceState.getString("reply_text6");
            mPresRBS = savedInstanceState.getString("reply_text7");
            //----------------------------------END-------------------------------------------------

            //----------------------------PERMANENT ADDRESS-----------------------------------------
            mPermCountry = savedInstanceState.getString("reply_text8");
            mPermDistrict = savedInstanceState.getString("reply_text9");
            mPermPostOffice = savedInstanceState.getString("reply_text10");
            mPermPoliceStation = savedInstanceState.getString("reply_text11");
            mPermPostalCode = savedInstanceState.getString("reply_text12");
            mPermHVC = savedInstanceState.getString("reply_text13");
            mPermRBS = savedInstanceState.getString("reply_text14");
            //------------------------------------END-----------------------------------------------
        }
        //-------------------------------------END--------------------------------------------------

    }

    @Override
    protected void onPause() {
        super.onPause();
        pref.setDataForm(studentName.getText().toString(), studentID.getText().toString(),dateOfBirth.getText().toString(),
                phoneNumber.getText().toString(), NID.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        //---------------------------CODE FOR SHARED PREFERENCE DATA--------------------------------
        studentName.setText(pref.getKeyName());
        studentID.setText(pref.getKeyId());
        schoolSpinner.setSelection(pref.getKeySchool());
        departmentSpinner.setSelection(pref.getKeyDepartment());
        dateOfBirth.setText(pref.getKeyDob());
        phoneNumber.setText(pref.getKeyPhone());
        NID.setText(pref.getKeyNid());

        //--------------------------------------END-------------------------------------------------
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        strSchool =  schoolSpinner.getSelectedItem().toString();
        pref.setSchoolSpinner(position);

        //---------------------------------SPINNER CODE FOR DEPARTMENTS-----------------------------
        if(position == 0){
            final String[] sbeDepartments = getResources().getStringArray(R.array.sbe_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sbeDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
            pref.setDepartmentSpinner(departmentSpinner.getSelectedItemPosition());

        }else
        if(position == 1){
            final String[] sepDepartments = getResources().getStringArray(R.array.sep_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sepDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
            pref.setDepartmentSpinner(departmentSpinner.getSelectedItemPosition());

        }else
        if(position == 2){
            final String[] shsDepartments = getResources().getStringArray(R.array.shs_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shsDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
            pref.setDepartmentSpinner(departmentSpinner.getSelectedItemPosition());

        }else
        if(position == 3){
            final String[] shlDepartments = getResources().getStringArray(R.array.shl_department_spinner);
            arrayAdapterDepartments = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shlDepartments);
            arrayAdapterDepartments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(arrayAdapterDepartments);
            pref.setDepartmentSpinner(departmentSpinner.getSelectedItemPosition());
        }


        //----------------------------------------------END-----------------------------------------
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }




    //-------------------------------CODE TO START ADDRESS ACTIVITY---------------------------------
    public void launchSecondActivity(View view) {
        Intent addressIntent = new Intent(this, Address.class);
        startActivityForResult(addressIntent, TEXT_REQUEST);
    }
    //-------------------------------------------END------------------------------------------------



    //--------------------------------CODE FOR INTENT RESULT----------------------------------------
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                //----------------------------------PRESENT ADDRESS---------------------------------
                mPresCountry = data.getStringExtra(Address.EXTRA_REPLY_1);
                mPresDistrict = data.getStringExtra(Address.EXTRA_REPLY_2);
                mPresPostOffice = data.getStringExtra(Address.EXTRA_REPLY_3);
                mPresPoliceStation = data.getStringExtra(Address.EXTRA_REPLY_4);
                mPresPostalCode = data.getStringExtra(Address.EXTRA_REPLY_5);
                mPresHVC = data.getStringExtra(Address.EXTRA_REPLY_6);
                mPresRBS = data.getStringExtra(Address.EXTRA_REPLY_7);
                //---------------------------------------END----------------------------------------

                //-----------------------------------PERMANENT ADDRESS------------------------------
                mPermCountry = data.getStringExtra(Address.EXTRA_REPLY_8);
                mPermDistrict = data.getStringExtra(Address.EXTRA_REPLY_9);
                mPermPostOffice = data.getStringExtra(Address.EXTRA_REPLY_10);
                mPermPoliceStation = data.getStringExtra(Address.EXTRA_REPLY_11);
                mPermPostalCode = data.getStringExtra(Address.EXTRA_REPLY_12);
                mPermHVC = data.getStringExtra(Address.EXTRA_REPLY_13);
                mPermRBS = data.getStringExtra(Address.EXTRA_REPLY_14);
                //---------------------------------------END----------------------------------------
            }
        }
    }
    //-------------------------------------------END------------------------------------------------

    //------------------------------------CODE FOR SAVE DATA----------------------------------------
    private void saveData (){
        StudentEntity student = new StudentEntity();

        student.setStudent_id(strStudentId);
        student.setStudent_name(strStudentName);
        student.setSchool(strSchool);
        student.setDepartment(strDepartment);
        student.setDob(strDoB);
        student.setPhone(strPhoneNumber);
        student.setNid(strNID);

        student.setPres_country(mPresCountry);
        student.setPres_district(mPresDistrict);
        student.setPres_post_office(mPresPostOffice);
        student.setPres_police_station(mPresPoliceStation);
        student.setPres_postal_code(mPresPostalCode);
        student.setPres_hvc(mPresHVC);
        student.setPres_rbs(mPresRBS);

        student.setPerm_country(mPermCountry);
        student.setPerm_district(mPermDistrict);
        student.setPerm_post_office(mPermPostOffice);
        student.setPerm_police_station(mPermPoliceStation);
        student.setPerm_postal_code(mPermPostalCode);
        student.setPerm_hvc(mPermHVC);
        student.setPerm_rbs(mPermRBS);

        studentViewModel.insert(student);

        studentName.setText("");
        studentID.setText("");
        schoolSpinner.setSelection(0);
        departmentSpinner.setSelection(0);
        dateOfBirth.setText("");
        phoneNumber.setText("");
        NID.setText("");

        Toast.makeText(getApplicationContext(),R.string.save_data,Toast.LENGTH_LONG).show();
    }
    //------------------------------------------END-------------------------------------------------

    //----------------------------CODE FOR STUDENT LIST ACTIVITY------------------------------------
    public void startStudentList(View view){
        Intent studentListIntent = new Intent(this,StudentList.class);
        startActivity(studentListIntent);
    }
    //----------------------------------------END---------------------------------------------------

    //-----------------------------CODE FOR SEARCH ACTIVITY-----------------------------------------
    public void startSearch(View view){
        Intent searchIntent = new Intent(this,StudentSearch.class);
        startActivity(searchIntent);
    }
    //----------------------------------------END---------------------------------------------------


    //----------------------------CODE FOR SAVED INSTANCE STATE-------------------------------------
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //---------------------------------------FORM INPUT-----------------------------------------
        outState.putString("reply1",strStudentName);
        outState.putString("reply2",strStudentId);
        outState.putString("reply3",strSchool);
        outState.putString("reply4",strDepartment);
        outState.putString("reply5",strDoB);
        outState.putString("reply6",phoneNumber.getText().toString());
        outState.putString("reply7",strNID);
        //------------------------------------------END---------------------------------------------

        //------------------------------------PRESENT ADDRESS---------------------------------------
        outState.putString("reply_text1",mPresCountry);
        outState.putString("reply_text2",mPresDistrict);
        outState.putString("reply_text3",mPresPostOffice);
        outState.putString("reply_text4",mPresPoliceStation);
        outState.putString("reply_text5",mPermPostalCode);
        outState.putString("reply_text6",mPresHVC);
        outState.putString("reply_text7",mPresRBS);
        //-----------------------------------------END----------------------------------------------

        //-----------------------------------PERMANENT ADDRESS--------------------------------------
        outState.putString("reply_text8",mPermCountry);
        outState.putString("reply_text9",mPermDistrict);
        outState.putString("reply_text10",mPermPostOffice);
        outState.putString("reply_text11",mPermPoliceStation);
        outState.putString("reply_text12",mPermPostalCode);
        outState.putString("reply_text13",mPermHVC);
        outState.putString("reply_text14",mPermRBS);
        //-----------------------------------------END----------------------------------------------
    }
    //-------------------------------------------END------------------------------------------------

    //------------------------------------CODE FOR SIGN OUT-----------------------------------------
    public void signout(View view){
        FirebaseAuth.getInstance().signOut();
        pref.logout();
        Intent intent = new Intent(StudentForm.this,Login.class);
        startActivity(intent);
        finish();
    }
    //-------------------------------------------END------------------------------------------------


    //-----------------------------------CODE FOR LANGUAGE SETTINGS---------------------------------
    private void showLanguageSelectDialog() {
        final String[] listItems = {getResources().getString(R.string.english),getResources().getString(R.string.bangla)};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(StudentForm.this);
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
