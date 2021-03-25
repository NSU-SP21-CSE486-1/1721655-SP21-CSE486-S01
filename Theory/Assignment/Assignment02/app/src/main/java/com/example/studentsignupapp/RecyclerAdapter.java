package com.example.studentsignupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentListHolder>{

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<StudentEntity> studentList;

    public RecyclerAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;

    }

    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item,parent,false);
        StudentListHolder listHolder = new StudentListHolder(itemView);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListHolder holder, int position) {
        if(studentList != null){
           StudentEntity students = studentList.get(position);
           holder.setData(students.getStudent_id(),position);
        }

    }

    @Override
    public int getItemCount() {
        if(studentList != null ){
          return studentList.size();
        }
        else  return 0;
    }

    public class StudentListHolder extends RecyclerView.ViewHolder{
        private TextView listItem;
        private int  itemPosition;
        public StudentListHolder(@NonNull View itemView) {
            super(itemView);
            listItem = itemView.findViewById(R.id.list_textView);
        }

        public void setData(String studentID, int position){
            listItem.setText(studentID);
            itemPosition = position;

        }
    }

    public void setStudentList(List<StudentEntity> students){
        studentList = students;
        notifyDataSetChanged();
    }
}
