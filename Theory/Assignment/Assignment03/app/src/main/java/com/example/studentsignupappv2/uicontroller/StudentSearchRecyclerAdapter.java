package com.example.studentsignupappv2.uicontroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsignupappv2.R;
import com.example.studentsignupappv2.datascource.StudentEntity;

import java.util.List;

public class StudentSearchRecyclerAdapter extends RecyclerView.Adapter<StudentSearchRecyclerAdapter.SearchListHolder>{
    private final LayoutInflater layoutInflater;
    private List<StudentEntity> studentList;
    private Context mContext;


    public StudentSearchRecyclerAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public SearchListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.student_search_item,parent,false);
        SearchListHolder listHolder = new SearchListHolder(itemView);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListHolder holder, int position) {
        if(studentList != null){
            StudentEntity students = studentList.get(position);
            holder.setData(students.getStudent_id(),position);
        }else{
            holder.listItem.setText(R.string.no_item);
        }

    }


    @Override
    public int getItemCount() {
        if(studentList != null ){
            return studentList.size();
        }
        else  return 0;
    }

    public void setStudentList(List<StudentEntity> students){
        studentList = students;
        notifyDataSetChanged();
    }


    public static class SearchListHolder extends RecyclerView.ViewHolder{
        private TextView listItem;
        private int  itemPosition;

        public SearchListHolder(View itemView) {
            super(itemView);
            listItem = itemView.findViewById(R.id.search_list_textView);
        }

        public void setData(String studentID, int position){
            listItem.setText(studentID);
            itemPosition = position;

        }
    }
}

