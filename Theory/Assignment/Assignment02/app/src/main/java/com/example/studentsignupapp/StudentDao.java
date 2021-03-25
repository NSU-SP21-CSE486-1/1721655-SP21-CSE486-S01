package com.example.studentsignupapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insert(StudentEntity students);

    @Update
    public Completable update(StudentEntity students);

    @Delete
    public Completable delete(StudentEntity students);


    @Query("SELECT * FROM student")
    LiveData<List<StudentEntity>> getALL();

    @Query("SELECT * FROM  student WHERE student_id IN (:studentID)")
    List<StudentEntity> getAllByID(String[] studentID);


}
