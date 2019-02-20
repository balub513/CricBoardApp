package com.example.balakrishnaballi.cricboardapp.module;

import android.app.Application;
import android.content.Context;

import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
