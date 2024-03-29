package com.example.studentsignupappv2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.repository.StudentRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private MutableLiveData<List<StudentEntity>> mAllStudents;
    private List<StudentEntity> stdAll;
    private final StudentRepository studentRep;
    private FirebaseAuth mRegister;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRep = StudentRepository.getInstance();
    }

    public void insert(StudentEntity student) {
        studentRep.insert(student);

    }

    public void initLive(){
        if(mAllStudents != null){
            return;
        }
        mAllStudents = studentRep.getAllStudents();
    }
    public void init(){
        if(stdAll != null){
            return;
        }
        stdAll = studentRep.getAll();
    }

    public void regInit(){
        if(mRegister != null){
            return;
        }
        mRegister = studentRep.registerUser();
    }

    public FirebaseAuth userRegister() { return mRegister; }

    public LiveData<List<StudentEntity>> getAllStudents(){
        return mAllStudents;
    }

    public List<StudentEntity> getAll(){
        return stdAll;
    }
}
