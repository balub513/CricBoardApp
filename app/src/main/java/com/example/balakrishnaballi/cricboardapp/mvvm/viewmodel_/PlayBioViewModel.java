package com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PlayBioViewModel extends AndroidViewModel {

    @Inject
    CricApi cricApi;

    MutableLiveData<PlayerBio> playerBioLiveData;

    MutableLiveData<String> responseLiveData;
    private DisposableSingleObserver<PlayerBio> playerBioDisposable;

    public PlayBioViewModel(@NonNull Application application) {
        super(application);
        CricboardApplication.getMyCricboardAppComponent().inject(this);
    }


    public void requestBio(int playerID) {
        playerBioLiveData = new MutableLiveData<PlayerBio>();
        responseLiveData = new MutableLiveData<String>();

        Single<PlayerBio> bioInformation = cricApi.getBioInformation(Consts.Network.API_KEY, String.valueOf(playerID));

        playerBioDisposable = bioInformation.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<PlayerBio>() {
                    @Override
                    public void onSuccess(PlayerBio playerBio) {
                        playerBioLiveData.setValue(playerBio);
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseLiveData.setValue(e.getMessage());
                    }
                });

    }

    public LiveData<PlayerBio> getPlayerBioLiveData() {
        return playerBioLiveData;
    }

    public LiveData<String> getResponseLiveData() {
        return responseLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (playerBioDisposable != null)
            playerBioDisposable.dispose();
    }
}
