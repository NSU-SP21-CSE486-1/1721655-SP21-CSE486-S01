package com.example.cpcapp.repository;



import android.app.job.JobInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cpcapp.datasource.AdminData;
import com.example.cpcapp.datasource.JobPost;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppRepository {

    private static AppRepository instance;
    private final FirebaseDatabase firebaseRef;
    private final FirebaseAuth firebaseAuth;
    private final DatabaseReference dbRef,adminDbRef,jobPostDbRef;
    private final DatabaseReference pdfDbRef;
    private final StorageReference storageReference,jobDescriptionRef;
    private final MutableLiveData<ArrayList<JobPost>> jobPostLiveData;


    private final ArrayList<AdminData> mAdminData;
    private final ArrayList<StudentInfoAPI> mAllStudent;
    private final ArrayList<JobPost> mJobPostList;

    public AppRepository(){
        mAllStudent = new ArrayList<>();
        mAdminData = new ArrayList<>();
        mJobPostList = new ArrayList<>();

        jobPostLiveData = new MutableLiveData<>();

        firebaseRef = FirebaseDatabase.getInstance();
        adminDbRef = firebaseRef.getReference("admin");
        dbRef = firebaseRef.getReference("students");
        pdfDbRef = firebaseRef.getReference("resume");
        jobPostDbRef = firebaseRef.getReference("job_posts");

        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        jobDescriptionRef = FirebaseStorage.getInstance().getReference();

    }

    public static AppRepository getInstance(){
        if(instance == null){
            instance = new AppRepository();
        }
        return instance;
    }



    public DatabaseReference getPdfDbRef(){return pdfDbRef;}
    public FirebaseAuth getAuthRef(){return firebaseAuth;}

    public ArrayList<AdminData> getAdminData(){
        adminDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    mAdminData.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        mAdminData.add(dataSnapshot.getValue(AdminData.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return mAdminData;
   }


   public MutableLiveData<ArrayList<JobPost>> getJobPostLiveData(){
        if(mJobPostList.size() == 0){
            getJobPostData();
        }
        jobPostLiveData.setValue(mJobPostList);
        return jobPostLiveData;
    }
   private void getJobPostData(){
        jobPostDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    mJobPostList.clear();
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        mJobPostList.add(dataSnapshot.getValue(JobPost.class));
                    }
                    jobPostLiveData.setValue(mJobPostList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
   }

    public void addStudentData(){
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    mAllStudent.clear();
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        mAllStudent.add(dataSnapshot.getValue(StudentInfoAPI.class));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

   public ArrayList<StudentInfoAPI> getStudentData(){
       if(mAllStudent.size() == 0){
           addStudentData();
       }

       return mAllStudent;
   }


    public StorageReference pdfStore(){
        return storageReference.child("resume"+System.currentTimeMillis()+".pdf");
    }
    public StorageReference storeRef(){
        return jobDescriptionRef.child("job_description"+System.currentTimeMillis());
    }
    public void insertStudent(StudentInfoAPI studentInfo){
        dbRef.child(studentInfo.getStudent_id()).setValue(studentInfo);
    }

    public void insertJobPost(JobPost jobPost){
        jobPostDbRef.child(String.valueOf(System.currentTimeMillis())).setValue(jobPost);
    }







}

