package com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerFinder;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerFinderViewModel extends AndroidViewModel {

    @Inject
    CricApi cricApi;

    MutableLiveData<String> liveDataErrorMsg = new MutableLiveData<String>();
    private MutableLiveData<PlayerFinder> liveDataSearchPlayers;

    public PlayerFinderViewModel(@NonNull Application application) {
        super(application);
        CricboardApplication.getMyCricboardAppComponent().inject(this);
    }


    public LiveData<PlayerFinder> getPlayersListBySearch(String playerName) {
        liveDataSearchPlayers = new MutableLiveData<PlayerFinder>();
        cricApi.getPlayersBySearch(Consts.Network.API_KEY, playerName).enqueue(new Callback<PlayerFinder>() {
            @Override
            public void onResponse(Call<PlayerFinder> call, Response<PlayerFinder> response) {
                PlayerFinder body = response.body();
                liveDataSearchPlayers.setValue(body);
            }

            @Override
            public void onFailure(Call<PlayerFinder> call, Throwable t) {
                liveDataErrorMsg.setValue(t.getMessage());
            }
        });
        return liveDataSearchPlayers;
    }

    List<PlayerFinder.Datum> list = new ArrayList<PlayerFinder.Datum>();

    public List<PlayerFinder.Datum> getPlayersListBySearch2(String playerName) {
        cricApi.getPlayersBySearch(Consts.Network.API_KEY, playerName).enqueue(new Callback<PlayerFinder>() {
            @Override
            public void onResponse(Call<PlayerFinder> call, Response<PlayerFinder> response) {
                PlayerFinder body = response.body();
                list = body.getData();
            }

            @Override
            public void onFailure(Call<PlayerFinder> call, Throwable t) {
                liveDataErrorMsg.setValue(t.getMessage());
            }
        });
        return list;
    }


}
