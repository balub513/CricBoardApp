package com.example.balakrishnaballi.cricboardapp.application;

import android.app.Application;
import android.content.Context;

import com.example.balakrishnaballi.cricboardapp.component.CricBoardAppComponent;
import com.example.balakrishnaballi.cricboardapp.component.DaggerCricBoardAppComponent;
import com.example.balakrishnaballi.cricboardapp.module.AppModule;

public class CricboardApplication extends Application {

    private static Application instance;

    private static Context context;
    private static CricBoardAppComponent cricBoardAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        cricBoardAppComponent = DaggerCricBoardAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
    }

    public static Application getMyCricboardApplication() {
        return instance;
    }

    public static Context getMyAppContext() {
        return context;
    }

    public static CricBoardAppComponent getMyCricboardAppComponent() {
        return cricBoardAppComponent;

    }

}
