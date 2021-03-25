package com.example.studentsignupapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class StudentList extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter ;
    private StudentDao studentDao;
    private LiveData<List<StudentEntity>> allStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        allStudent = studentDao.getALL();
        allStudent.observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(List<StudentEntity> studentEntities) {
                recyclerAdapter.setStudentList(studentEntities);
            }
        });
    }


}