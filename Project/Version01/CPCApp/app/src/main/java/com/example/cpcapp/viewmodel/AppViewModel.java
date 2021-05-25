package com.example.cpcapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cpcapp.datasource.AdminData;
import com.example.cpcapp.datasource.JobPost;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.repository.AppRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private final AppRepository appRepository;
    private DatabaseReference dbRef,pdfDbRef,jobPostDbRef;
    private ArrayList<StudentInfoAPI> arrayList;
    private ArrayList<AdminData> adminData;
    private FirebaseAuth firebaseAuth;
    private StorageReference storageReference;
    private StorageReference jobDescriptionRef;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance();
        arrayList = appRepository.getStudentData();
        adminData = appRepository.getAdminData();
        firebaseAuth = appRepository.getAuthRef();


    }


    public void initDbRef(){
        if(dbRef != null){
            return;
        }
        dbRef = appRepository.getDbRef();

    }

    public DatabaseReference getDbRef(){

        return dbRef;
    }

    public void initPdfDbRef(){
        if(pdfDbRef != null){
            return;
        }
        pdfDbRef = appRepository.getPdfDbRef();
    }

    public DatabaseReference getPdfDbRef(){
        return pdfDbRef;
    }

    public ArrayList<StudentInfoAPI> getStudentData(){

        return arrayList;
    }

    public ArrayList<AdminData> getAdminData(){
        return adminData;
    }

    public void initStorageRef(){
        if(storageReference != null){
            return;
        }
        storageReference = appRepository.pdfStore();
    }

    public StorageReference getStorageReference(){
        return storageReference;
    }

    public void initJobDescriptionRef(){
        if(jobDescriptionRef != null){
            return;
        }
        jobDescriptionRef = appRepository.storeRef();
    }
    public StorageReference getJobDescriptionRef(){ return jobDescriptionRef;}



    public FirebaseAuth getAuthRef(){
        return firebaseAuth;
    }


    public void insertStudent(StudentInfoAPI studentInfo){
        appRepository.insertStudent(studentInfo);
    }

    public void insertJobPost(JobPost jobPost){
        appRepository.insertJobPost(jobPost);
    }


}
