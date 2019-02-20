package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;

import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Match;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Matches;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class UpcomingMatchesPresenter extends BasePresenter {

    private final com.example.balakrishnaballi.cricboardapp.mvp.view.view.UpcomingMatchesView view;

    CricApi cricApi;


    public UpcomingMatchesPresenter(Lifecycle lifecycle, com.example.balakrishnaballi.cricboardapp.mvp.view.view.UpcomingMatchesView view, CricApi cricApi) {
        super(lifecycle);
        this.view = view;
        this.cricApi = cricApi;
    }

    public void requestUpcomingCricketMatches() {


        DisposableSingleObserver<Matches> disposableSingleObserver =
                cricApi.getUpcomongMatches(Consts.Network.API_KEY)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribeWith(new DisposableSingleObserver<Matches>() {
                            @Override
                            public void onSuccess(Matches matches) {

                                List<Match> matchList = matches.getMatches();
                                view.sendBackUpcomingMathces(matchList);

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.sendErrorReport(e.getMessage());

                            }
                        });

        disposable.add(disposableSingleObserver);


    }
}
