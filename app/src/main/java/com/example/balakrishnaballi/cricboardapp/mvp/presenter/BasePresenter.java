package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter implements LifecycleObserver {

    private Lifecycle lifecycle;

    CompositeDisposable disposable = new CompositeDisposable();

    public BasePresenter(Lifecycle lifecycle) {

        this.lifecycle = lifecycle;
        if (this.lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory() {
        disposable.dispose();
        if (this.lifecycle != null)
            lifecycle.removeObserver(this);


    }
}
