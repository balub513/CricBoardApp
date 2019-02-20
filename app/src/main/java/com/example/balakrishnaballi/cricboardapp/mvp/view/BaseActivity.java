package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    public static MutableLiveData<String> mutableScreenName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public MutableLiveData<String> getMutableScreenName() {
        if (mutableScreenName == null)
            mutableScreenName = new MutableLiveData<>();

        return mutableScreenName;

    }
}
