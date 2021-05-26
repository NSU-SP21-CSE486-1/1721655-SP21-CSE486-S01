package com.example.cpcapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cpcapp.R;
import com.example.cpcapp.adapters.NoticeBoardAdapter;
import com.example.cpcapp.datasource.JobPost;
import com.example.cpcapp.viewmodel.AppViewModel;

import java.util.ArrayList;

public class NoticeBoard extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppViewModel appViewModel;
    private LiveData<ArrayList<JobPost>> jobPostLiveData;
    private NoticeBoardAdapter noticeBoardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        appViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(this.getApplication())).get(AppViewModel.class);
        appViewModel.initJobPostLiveData();
        jobPostLiveData = appViewModel.getJobPostLiveData();

        recyclerView = findViewById(R.id.recycler_view);
        noticeBoardAdapter = new NoticeBoardAdapter(this);
        recyclerView.setAdapter(noticeBoardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        jobPostLiveData.observe(this, new Observer<ArrayList<JobPost>>() {
            @Override
            public void onChanged(ArrayList<JobPost> jobPosts) {
                noticeBoardAdapter.setJobPostList(jobPosts);
            }
        });



    }
}