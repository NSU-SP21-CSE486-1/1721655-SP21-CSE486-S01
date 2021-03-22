package com.example.studentsignupapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertAll(StudentEntity student);

    @Query("SELECT * FROM student")
    List<StudentEntity> getALL();

    @Query("SELECT * FROM  student WHERE student_id IN (:studentID)")
    List<StudentEntity> getAllByID(String[] studentID);


}
