package com.example.cpcapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cpcapp.R;
import com.example.cpcapp.datasource.JobPost;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoardAdapter extends RecyclerView.Adapter<NoticeBoardAdapter.NoticeBoardHolder> {
    private final LayoutInflater layoutInflater;
    private Context mContext;
    private ArrayList<JobPost> jobPostList;


    public NoticeBoardAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public NoticeBoardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.job_board_view,parent,false);
        NoticeBoardHolder noticeBoardHolder = new NoticeBoardHolder(itemView);
        return noticeBoardHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeBoardAdapter.NoticeBoardHolder holder, int position) {
        if(jobPostList != null){
           JobPost jobPost = jobPostList.get(position);
           holder.setData(jobPost.getCompany_name(), jobPost.getApplication_date());
        }

    }

    @Override
    public int getItemCount() {
        if(jobPostList != null){
            return jobPostList.size();
        }else return 0;
    }

    public void setJobPostList(ArrayList<JobPost> jobPostList){
        this.jobPostList = jobPostList;
        notifyDataSetChanged();
    }

    public class NoticeBoardHolder extends RecyclerView.ViewHolder {

        private TextView company_name,application_date;

        public NoticeBoardHolder(@NonNull View itemView) {
            super(itemView);
            company_name = itemView.findViewById(R.id.job_view_company_name_textView);
            application_date = itemView.findViewById(R.id.job_view_application_date_textView);
        }

        public void setData(String company_name,String application_date){
            this.company_name.setText(company_name);
            this.application_date.setText(application_date);
        }

    }
}
