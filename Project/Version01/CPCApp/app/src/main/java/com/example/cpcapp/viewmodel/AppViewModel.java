package com.example.cpcapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.cpcapp.repository.AppRepository;



public class AppViewModel extends AndroidViewModel {

    private final AppRepository appRepository;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance();
    }
}
