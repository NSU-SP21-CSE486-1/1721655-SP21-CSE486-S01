package com.example.cpcapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.JobPost;
import com.example.cpcapp.datasource.PDFData;
import com.example.cpcapp.viewmodel.AppViewModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddJob extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner jobsTypeSpinner;
    private ArrayAdapter<String> arrayAdapter;
    private EditText company_name,position_name,salary_range,job_description,application_date,recruiter_email;
    private Uri dataUri,uri;
    private AppViewModel appViewModel;
    private StorageReference storageReference;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);
        appViewModel.initJobDescriptionRef();
        storageReference = appViewModel.getJobDescriptionRef();


        company_name = findViewById(R.id.company_name_editText);
        position_name = findViewById(R.id.position_name_editText);
        salary_range = findViewById(R.id.salary_range_editText);
        job_description = findViewById(R.id.job_description_editText);
        application_date = findViewById(R.id.application_date_editText);
        recruiter_email = findViewById(R.id.recruiter_email_editTextText);




        jobsTypeSpinner = findViewById(R.id.job_type_spinner);
        jobsTypeSpinner.setOnItemSelectedListener(this);
        final String[] jobTypes = getResources().getStringArray(R.array.job_types);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,jobTypes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobsTypeSpinner.setAdapter(arrayAdapter);


        job_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFile();
            }
        });


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        application_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker = new DatePickerDialog(AddJob.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        application_date.setText(date);
                    }
                },year,month,day);
                datePicker.show();
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void selectFile() {
        Intent intent = new Intent();
        intent.setType("application/pdf image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"SELECT FILE"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10 && resultCode == RESULT_OK && data != null && data.getData() != null){

            job_description.setText(data.getDataString().substring(data
                    .getDataString().lastIndexOf("/") + 1));
            dataUri = data.getData();
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("File is uploading....");
            progressDialog.show();

            storageReference.putFile(dataUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while(!uriTask.isComplete());
                    uri = uriTask.getResult();


                    Toast.makeText(AddJob.this, "Uploaded.", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progress = (100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                    progressDialog.setMessage("File Uploading.." + (int) progress + "%");

                }
            });


        }
    }


    public void Post(View view) {


        JobPost jobPost = new JobPost(company_name.getText().toString(),position_name.getText().toString(),jobsTypeSpinner.getSelectedItem().toString(),
                salary_range.getText().toString(),uri.toString(),application_date.getText().toString(),recruiter_email.getText().toString());


        appViewModel.insertJobPost(jobPost);

        Toast.makeText(getApplicationContext(),"Job Posted",Toast.LENGTH_SHORT).show();
    }
}