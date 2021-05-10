package com.example.cpcapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.repository.AppRepository;
import com.google.firebase.database.DatabaseReference;

import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private final AppRepository appRepository;
    private DatabaseReference dbRef;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance();
        dbRef = appRepository.getDbRef();
    }


    public DatabaseReference getDbRef(){

        return dbRef;
    }

    public boolean registerStudent(String email,String password){

        return appRepository.registerStudent(email,password);
    }

}
