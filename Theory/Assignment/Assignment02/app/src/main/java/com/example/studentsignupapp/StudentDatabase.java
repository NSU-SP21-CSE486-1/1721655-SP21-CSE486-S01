package com.example.studentsignupapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {StudentEntity.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao getDao();
    private static StudentDatabase instance;


}
