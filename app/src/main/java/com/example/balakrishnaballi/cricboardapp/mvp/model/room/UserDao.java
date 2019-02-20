package com.example.balakrishnaballi.cricboardapp.mvp.model.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface UserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Query("SELECT * FROM usertable")
    Single<List<User>> getUsers();

    @Query("SELECT * FROM usertable")
    LiveData<List<User>> getUsersAsLiveData();

}
