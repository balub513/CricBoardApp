package com.example.balakrishnaballi.cricboardapp.mvp.presenter;

import android.arch.lifecycle.Lifecycle;

import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ScoreCardPresenter extends BasePresenter {

    private final com.example.balakrishnaballi.cricboardapp.mvp.view.view.ScorecardView view;
    private final CricApi cricApi;

    public ScoreCardPresenter(Lifecycle lifecycle, view.ScorecardView view, CricApi cricApi) {
        super(lifecycle);
        this.view = view;
        this.cricApi = cricApi;
    }

    public void requestScoreCard(String matchUniqueId) {

        DisposableSingleObserver<ScoreCard> scoreCardDisposableSingleObserver = cricApi.getFullScoreCard(Consts.Network.API_KEY, matchUniqueId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<ScoreCard>() {
                    @Override
                    public void onSuccess(ScoreCard scoreCard) {
                        view.senBackScoreCard(scoreCard);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.sendbackErrorResponse(e.getMessage());

                    }
                });
        disposable.add(scoreCardDisposableSingleObserver);

    }
}
