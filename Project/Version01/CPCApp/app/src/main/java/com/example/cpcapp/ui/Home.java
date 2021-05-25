package com.example.cpcapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.SharedPrefManager;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private androidx.appcompat.widget.Toolbar toolbar;
    private SharedPrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pref = new SharedPrefManager(Home.this);

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.home_nav_menu);
        drawerLayout = findViewById(R.id.home_drawer);


        actionBarDrawerToggle =
                new ActionBarDrawerToggle(Home.this,drawerLayout,toolbar,
                        R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

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
    }
}