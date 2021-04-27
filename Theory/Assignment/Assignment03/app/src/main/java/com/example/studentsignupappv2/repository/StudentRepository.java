package com.example.studentsignupappv2.repository;





import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.studentsignupappv2.datascource.StudentEntity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class StudentRepository {
 private static StudentRepository instance;
 private final FirebaseDatabase firebaseRef;
 private final FirebaseAuth  firebaseAuth;
 private final DatabaseReference dbRef;
 private List<StudentEntity> mAllStudent;
 private MutableLiveData<List<StudentEntity>> students;

 public StudentRepository(){
  firebaseRef = FirebaseDatabase.getInstance();
  dbRef =  firebaseRef.getReference("user");
  mAllStudent = new ArrayList<>();
  students = new MutableLiveData<>();
  firebaseAuth = FirebaseAuth.getInstance();

 }

 public static StudentRepository getInstance(){
  if(instance == null){
   instance = new StudentRepository();
  }
  return instance;
 }

 private void loadStudents(){
     dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
   @Override
   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
        mAllStudent.add(snapshot.getValue(StudentEntity.class));
    }
    students.postValue(mAllStudent);
   }

   @Override
   public void onCancelled(@NonNull DatabaseError error) {

   }
  });
 }


 public void insert(StudentEntity student){
   dbRef.child(student.getStudent_id()).setValue(student);
 }

 public MutableLiveData<List<StudentEntity>> getAllStudents(){
  if(mAllStudent.size() == 0) {
   loadStudents();
  }
  students.setValue(mAllStudent);
  return students;
 }

 public List<StudentEntity> getAll(){
     if(mAllStudent.size() == 0){
         loadStudents();
     }

     return mAllStudent;
 }

 public FirebaseAuth  registerUser(){
    return firebaseAuth;
 }

}
