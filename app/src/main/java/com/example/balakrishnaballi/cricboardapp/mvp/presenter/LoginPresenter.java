package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.util.Log;

import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.view.LoginActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter {

    private com.example.balakrishnaballi.cricboardapp.mvp.view.view.LoginView view;
    private UserDao userDao;

    public LoginPresenter(Lifecycle lifecycle) {
        super(lifecycle);
    }

    public LoginPresenter(Lifecycle lifecycle, view.LoginView view, UserDao userDao) {
        super(lifecycle);
        this.view = view;
        this.userDao = userDao;
    }

    public void requestLogin(final User user1) {

        Single<List<User>> users = userDao.getUsers();
        DisposableSingleObserver<List<User>> singleObserver = users
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<List<User>>() {
                    @Override
                    public void onSuccess(List<User> users) {
                        if (isValidateuser(users, user1))
                            view.loginSuccess();
                        else
                            view.loginFail();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.loginFail();
                    }
                });

        disposable.add(singleObserver);
    }

    private boolean isValidateuser(List<User> users, User user1) {
        for (User user : users) {
            if (user.getEmailId().equals(user1.getEmailId()) && user.getPassword().equals(user1.getPassword()))
                return true;
        }
        return false;
    }
}
