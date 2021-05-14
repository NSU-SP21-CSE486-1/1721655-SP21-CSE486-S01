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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppRepository {

    private static AppRepository instance;
    private final FirebaseDatabase firebaseRef;
    private final FirebaseAuth firebaseAuth;
    private final DatabaseReference dbRef;


    private final ArrayList<StudentInfoAPI> mAllStudent;
    private final MutableLiveData<List<StudentInfoAPI>> mStudents;
    private boolean check2;

    public AppRepository(){
        mAllStudent = new ArrayList<>();
        mStudents = new MutableLiveData<>();
        firebaseRef = FirebaseDatabase.getInstance();
        dbRef = firebaseRef.getReference("students");
        firebaseAuth = FirebaseAuth.getInstance();

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
   public FirebaseAuth getAuthRef(){return firebaseAuth;}

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












}

