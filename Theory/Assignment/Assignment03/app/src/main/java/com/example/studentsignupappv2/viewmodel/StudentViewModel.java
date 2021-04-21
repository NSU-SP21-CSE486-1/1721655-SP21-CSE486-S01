package com.example.studentsignupappv2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.repository.StudentRepository;

public class StudentViewModel extends AndroidViewModel {
    private final StudentRepository studentRep;
    public StudentViewModel(@NonNull Application application) {
        super(application);

        studentRep = new StudentRepository();
    }

    public void insert(StudentEntity student){
        studentRep.insert(student);
    }
}
