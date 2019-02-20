package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstScreen extends BaseActivity {

    private static final String TAG = "FirstScreen";
    @BindView(R.id.btn_register)
    Button register;

    @BindView(R.id.btn_login)
    Button login;

    @BindView(R.id.imageview_icon)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.imageview_icon)
    public void clickImageIcon() {
        startActivity(new Intent(this, RegisteredUsersListActivity.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LiveData<String>) getMutableScreenName()).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "livedate*: " + getMutableScreenName().getValue());
            }
        });
        Log.d(TAG, "livedate*: " + getMutableScreenName().getValue());
    }

    @OnClick(R.id.btn_login)
    public void login() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btn_register)
    public void register() {
        startActivity(new Intent(this, SignupActivity.class));
    }
}
