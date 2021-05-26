package com.example.cpcapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.SharedPrefManager;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.example.cpcapp.viewmodel.AppViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private androidx.appcompat.widget.Toolbar toolbar;
    private SharedPrefManager pref;
    private TextView userEmail,userName;
    private ArrayList<StudentInfoAPI> studentList;
    private AppViewModel appViewModel;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pref = new SharedPrefManager(Home.this);
        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);

        appViewModel.initStudentData();
        studentList = appViewModel.getStudentData();

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.home_nav_menu);
        drawerLayout = findViewById(R.id.home_drawer);

        actionBarDrawerToggle =
                new ActionBarDrawerToggle(Home.this,drawerLayout,toolbar,
                        R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        View headerView = navigationView.getHeaderView(0);

        userName = headerView.findViewById(R.id.user_full_name);
        userEmail = headerView.findViewById(R.id.user_nsu_email);



        navigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){

                    case R.id.menu_home :
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        finish();
                        break;

                    case R.id.menu_notice_board:
                        startActivity(new Intent(getApplicationContext(),NoticeBoard.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:
                        pref.logout();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        finish();
                        break;


                }

                return true;
            }
        });

        updateNavHeader();


    }


    public void updateNavHeader(){
        userEmail.setText(pref.getEmail());
        for(StudentInfoAPI studentInfoAPI : studentList){
            if(studentInfoAPI.getStudent_nsu_email().equals(pref.getEmail())){
                name = studentInfoAPI.getStudent_name();
                break;
            }
        }
        userName.setText(name);
    }

    public void OpenNoticeBoard(View view) {
        startActivity(new Intent(getApplicationContext(),NoticeBoard.class));
    }
}