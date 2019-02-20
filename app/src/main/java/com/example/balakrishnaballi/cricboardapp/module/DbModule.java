package com.example.balakrishnaballi.cricboardapp.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDataBase;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    public UserDao provideUserDao(UserDataBase userDataBase) {
        return userDataBase.getUserDao();
    }

    @Provides
    public UserDataBase provideUserDataBase(Context context) {
        UserDataBase userDataBase = Room.databaseBuilder(context, UserDataBase.class, UserDataBase.DB_NAME).build();
        return userDataBase;
    }

}
