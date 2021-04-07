package com.example.studentsignupapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    private List<StudentEntity> listStudent;
    private StudentDao studentDao;
    private StudentDatabase studentDB;
    private RecyclerView recyclerView;
    private SearchListAdapter recyclerAdapter;
    private String id,department,school;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.label_search));

        recyclerView = findViewById(R.id.search_recyclerView);
        recyclerAdapter = new SearchListAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.student_search);
        studentSearch(searchView);

    }



    public void studentSearch(SearchView view){

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
            studentDB = StudentDatabase.getDatabase(this.getApplicationContext());
            studentDao = studentDB.getDao();
            listStudent = studentDao.getAllStudent();
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
            studentDB = StudentDatabase.getDatabase(this.getApplicationContext());
            studentDao = studentDB.getDao();
            listStudent = studentDao.getAllStudent();
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
            studentDB = StudentDatabase.getDatabase(this.getApplicationContext());
            studentDao = studentDB.getDao();
            listStudent = studentDao.getAllStudent();
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