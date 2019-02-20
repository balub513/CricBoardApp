package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class UsersListPresenter extends BasePresenter {
    private LifecycleOwner lifecycleOwner;
    private Lifecycle lifecycle;
    private final com.example.balakrishnaballi.cricboardapp.mvp.view.view.UsersListView view;
    private final UserDao userDao;

    public UsersListPresenter(LifecycleOwner lifecycleOwner, Lifecycle lifecycle, view.UsersListView view, UserDao userDao) {
        super(lifecycle);
        this.lifecycleOwner = lifecycleOwner;
        this.view = view;
        this.userDao = userDao;
    }

    public void getRegisteredUsers() {

        LiveData<List<User>> usersAsLiveData = userDao.getUsersAsLiveData();
        usersAsLiveData.observe(lifecycleOwner, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                view.sendBackusersList(users);
            }
        });
    }

    public void addUser(final User user) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                userDao.addUser(user);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                view.addUserSuccessful();
            }

            @Override
            public void onError(Throwable e) {
                view.addUserFailure();

            }
        });
    }
}
