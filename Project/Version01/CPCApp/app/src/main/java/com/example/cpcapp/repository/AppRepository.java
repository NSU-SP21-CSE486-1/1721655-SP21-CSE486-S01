package com.example.cpcapp.repository;



import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
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
    private final DatabaseReference dbRef,adminDbRef;
    private final DatabaseReference pdfDbRef;
    private final StorageReference storageReference;


    private final ArrayList<String> mAdminData;
    private final ArrayList<StudentInfoAPI> mAllStudent;

    public AppRepository(){
        mAllStudent = new ArrayList<>();
        mAdminData = new ArrayList<>();
        firebaseRef = FirebaseDatabase.getInstance();
        adminDbRef = firebaseRef.getReference("admin");
        dbRef = firebaseRef.getReference("students");
        pdfDbRef = firebaseRef.getReference("resume");
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

    }

    public static AppRepository getInstance(){
        if(instance == null){
            instance = new AppRepository();
        }
        return instance;
    }

   public DatabaseReference getDbRef(){
        return dbRef;
   }
   public DatabaseReference getPdfDbRef(){return pdfDbRef;}
   public FirebaseAuth getAuthRef(){return firebaseAuth;}
   public ArrayList<String> getAdminData(){
        adminDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    mAdminData.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        mAdminData.add(dataSnapshot.getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return mAdminData;
   }

   public ArrayList<StudentInfoAPI> getStudentData(){
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

       return mAllStudent;
   }


    public StorageReference pdfStore(){
        return storageReference.child("resume"+System.currentTimeMillis()+".pdf");
    }
    public void insertStudent(StudentInfoAPI studentInfo){
        dbRef.child(studentInfo.getStudent_id()).setValue(studentInfo);
    }









}

