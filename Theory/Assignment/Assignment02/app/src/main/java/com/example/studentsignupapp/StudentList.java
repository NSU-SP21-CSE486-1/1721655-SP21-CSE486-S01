package com.example.studentsignupapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class StudentList extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter ;
    private StudentDao studentDao;
    private StudentDatabase studentDB;
    private LiveData<List<StudentEntity>> allStudent;
    private RecyclerView recyclerView;
    private TextView listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        studentDB = StudentDatabase.getDatabase(this);
        studentDao = studentDB.getDao();
        allStudent = studentDao.getALL();

        allStudent.observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(@Nullable List<StudentEntity> studentEntities) {
                recyclerAdapter.setStudentList(studentEntities);
            }
        });

    }


}