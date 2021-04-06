package com.example.studentsignupapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentListHolder>{

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<StudentEntity> studentList;
    private Dialog dialog;


    public RecyclerAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;

    }


    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item,parent,false);
        StudentListHolder listHolder = new StudentListHolder(itemView);

        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.popup_message);




        listHolder.list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"Clicked",Toast.LENGTH_LONG).show();
                TextView dialogName = (TextView) dialog.findViewById(R.id.popup_name);
                TextView dialogDepartment = (TextView) dialog.findViewById(R.id.popup_department);
                dialogName.setText(studentList.get(listHolder.getAdapterPosition()).getStudent_name());
                dialogDepartment.setText(studentList.get(listHolder.getAdapterPosition()).getDepartment());
                dialog.show();
            }
        });


        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListHolder holder, int position) {
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

    public static class StudentListHolder extends RecyclerView.ViewHolder{
        private LinearLayout list;
        private TextView listItem;
        private int  itemPosition;

        public StudentListHolder(View itemView) {
            super(itemView);
            list = (LinearLayout) itemView.findViewById(R.id.linearlayout_item);
            listItem = itemView.findViewById(R.id.list_textView);
        }

        public void setData(String studentID, int position){
            listItem.setText(studentID);
            itemPosition = position;

        }
    }














}
