package com.example.balakrishnaballi.cricboardapp.network;


import com.example.balakrishnaballi.cricboardapp.mvp.model.Matches;
import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerFinder;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CricApi {


    @GET("matches")
    public Single<Matches> getUpcomongMatches(@Query("apikey") String apiKey);

    @GET("cricket")
    public Single<OldMatches> getOldMatches(@Query("apikey") String apiKey);

    @GET("fantasySummary")
    public Single<ScoreCard> getFullScoreCard(@Query("apikey") String apiKey, @Query("unique_id") String unique_id);




    @GET("playerStats")
    public Single<PlayerBio> getBioInformation(@Query("apikey") String apiKey, @Query("pid") String pid);

    @GET("playerFinder")
    public Call<PlayerFinder> getPlayersBySearch(@Query("apikey") String apiKey, @Query("name") String name);


}
