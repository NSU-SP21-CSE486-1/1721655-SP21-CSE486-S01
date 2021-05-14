package com.example.cpcapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.repository.AppRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private final AppRepository appRepository;
    private DatabaseReference dbRef;
    private ArrayList<StudentInfoAPI> arrayList;
    private FirebaseAuth firebaseAuth;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance();
        arrayList = appRepository.getStudentData();
        firebaseAuth = appRepository.getAuthRef();

    }


    public void initDbRef(){
        if(dbRef != null){
            return;
        }
        dbRef = appRepository.getDbRef();

    }

    public ArrayList<StudentInfoAPI> getStudentData(){

        return arrayList;
    }

    public DatabaseReference getDbRef(){

        return dbRef;
    }

    public FirebaseAuth getAuthRef(){
        return firebaseAuth;
    }



}
