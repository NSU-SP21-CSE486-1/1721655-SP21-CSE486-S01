package com.example.cpcapp.repository;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppRepository {

    private static AppRepository instance;
    private final FirebaseDatabase firebaseRef;
    private final FirebaseAuth firebaseAuth;
    private final DatabaseReference dbRef;
    private boolean check ;

    public AppRepository(){
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

    private boolean checkStudent(String fullName,String nsuId,String nsuEmail,String dob,String nid){
      dbRef.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

              for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                 if(snapshot.child("student_name").getValue().toString() == fullName &&
                    snapshot.child("student_nsu_id").getValue().toString() == nsuId &&
                    snapshot.child("student_nsu_email").getValue().toString() == nsuEmail &&
                    snapshot.child("student_dob").getValue().toString() == dob &&
                    snapshot.child("student_nid").getValue().toString() == nid){

                     check = true;
                 }else{
                     check = false;
                 }
              }

          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });

      return check;
    }


}
