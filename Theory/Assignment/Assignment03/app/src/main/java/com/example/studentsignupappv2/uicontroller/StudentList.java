package com.example.studentsignupappv2.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;

import android.os.Bundle;

import java.util.List;

public class StudentList extends AppCompatActivity {
    private StudentListRecyclerAdapter studentListRecyclerAdapter;
    private LiveData<List<StudentEntity>> allStudents;
    private RecyclerView recyclerView;
    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        viewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        recyclerView = findViewById(R.id.recycler_view);
        studentListRecyclerAdapter = new StudentListRecyclerAdapter(this);
        recyclerView.setAdapter(studentListRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.initLive();
        allStudents = viewModel.getAllStudents();
        allStudents.observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(List<StudentEntity> studentEntities) {
                studentListRecyclerAdapter.setStudentList(studentEntities);
            }
        });


    }
}