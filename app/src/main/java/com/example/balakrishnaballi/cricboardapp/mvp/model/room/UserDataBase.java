package com.example.balakrishnaballi.cricboardapp.mvp.model.room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public static final String DB_NAME = "user_db";

    public abstract UserDao getUserDao();
}
