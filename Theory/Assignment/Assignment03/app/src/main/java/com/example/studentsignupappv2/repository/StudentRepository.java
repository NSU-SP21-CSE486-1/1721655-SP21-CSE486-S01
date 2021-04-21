package com.example.studentsignupappv2.repository;



import com.example.studentsignupappv2.datascource.StudentEntity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class StudentRepository {

 private static final int THREADS_NUMBER= 4;
 private static final ExecutorService threadExecutor = Executors.newFixedThreadPool(THREADS_NUMBER);
 private final FirebaseDatabase firebaseRef;
 private final DatabaseReference dbRef;

 public StudentRepository(){
  firebaseRef = FirebaseDatabase.getInstance();
  dbRef =  firebaseRef.getReference("user");
 }

 public static ExecutorService getThreadExecutor(){return threadExecutor;}

 public void insert(StudentEntity student){
   dbRef.child(student.getStudent_id()).setValue(student);
 }



}
