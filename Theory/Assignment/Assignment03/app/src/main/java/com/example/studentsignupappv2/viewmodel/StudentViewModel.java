package com.example.studentsignupappv2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.repository.StudentRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private MutableLiveData<List<StudentEntity>> mAllStudents;
    private final StudentRepository studentRep;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRep = StudentRepository.getInstance();
        mAllStudents = studentRep.getAllStudents();
    }

    public void insert(StudentEntity student) {
        studentRep.insert(student);

    }

    public LiveData<List<StudentEntity>> getAllStudents(){
        return mAllStudents;
    }
}
