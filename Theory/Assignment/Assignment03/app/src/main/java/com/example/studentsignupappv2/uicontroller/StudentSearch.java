package com.example.studentsignupappv2.uicontroller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.datascource.StudentEntity;
import com.example.studentsignupappv2.viewmodel.StudentViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentSearch extends AppCompatActivity {
    private List<StudentEntity> listStudent;
    private RecyclerView recyclerView;
    private StudentSearchRecyclerAdapter recyclerAdapter;
    private String id,department,school;
    private StudentViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.label_search));
        viewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        recyclerView = findViewById(R.id.search_recyclerView);
        recyclerAdapter = new StudentSearchRecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.student_search);
        studentSearch(searchView);
    }

    private void studentSearch(SearchView view) {
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query != null){
                    id = query;
                    department = query;
                    school = query;
                }else
                {
                    Toast.makeText(getApplicationContext(),R.string.empty_search_field,Toast.LENGTH_LONG).show();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                return false;
            }
        });
    }

    public void idFilter(View view) {
        if(id != null) {
            viewModel.init();
            listStudent = viewModel.getAll();
            ArrayList<StudentEntity> filteredStudentList = new ArrayList<>();
            for (StudentEntity student : listStudent) {
                if (student.getStudent_id().contentEquals(id))
                    filteredStudentList.add(student);
                else
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.no_results_found),Toast.LENGTH_SHORT).show();

            }

            recyclerAdapter.setStudentList(filteredStudentList);
        }else
        {
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.empty_search_field),Toast.LENGTH_SHORT).show();
        }


    }

    public void departmentFilter(View view) {
        if(department != null) {
            viewModel.init();
            listStudent = viewModel.getAll();
            ArrayList<StudentEntity> filteredStudentList = new ArrayList<>();
            for (StudentEntity student : listStudent) {
                if (student.getDepartment().toLowerCase().contentEquals(department.toLowerCase()))
                    filteredStudentList.add(student);
                else
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.no_results_found), Toast.LENGTH_SHORT).show();
            }

            recyclerAdapter.setStudentList(filteredStudentList);
        }else{
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.empty_search_field),Toast.LENGTH_SHORT).show();
        }
    }


    public void schoolFilter(View view) {
        if(school != null) {
            viewModel.init();
            listStudent = viewModel.getAll();
            ArrayList<StudentEntity> filteredStudentList = new ArrayList<>();
            for (StudentEntity student : listStudent) {
                if (student.getSchool().toLowerCase().contentEquals(school.toLowerCase()))
                    filteredStudentList.add(student);
                else
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.no_results_found), Toast.LENGTH_SHORT).show();
            }

            recyclerAdapter.setStudentList(filteredStudentList);
        }else{
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.empty_search_field),Toast.LENGTH_SHORT).show();
        }


   }

}