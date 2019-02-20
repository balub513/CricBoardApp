package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.os.AsyncTask;

import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignupPresenter extends BasePresenter {

    private final com.example.balakrishnaballi.cricboardapp.mvp.view.view.SignupView view;
    private final UserDao userDao;

    public SignupPresenter(Lifecycle lifecycle, view.SignupView view, UserDao userDao) {
        super(lifecycle);
        this.view = view;
        this.userDao = userDao;
    }

    public void registerUser(final User user) {

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
                Single<List<User>> users = userDao.getUsers();
                view.registraionSuccessful();
            }

            @Override
            public void onError(Throwable e) {
                view.errorInRegistraion();
            }
        });

    }


}
