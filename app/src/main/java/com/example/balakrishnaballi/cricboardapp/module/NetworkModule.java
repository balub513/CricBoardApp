package com.example.balakrishnaballi.cricboardapp.module;

import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    public CricApi provideCricApiClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        CricApi cricApi = new Retrofit.Builder().baseUrl(Consts.Network.BASE_URL_CRIC)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build().create(CricApi.class);

        return cricApi;
    }
}
