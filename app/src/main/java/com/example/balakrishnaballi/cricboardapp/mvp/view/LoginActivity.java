package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements view.LoginView {

    private static final String TAG = "LoginActivity";

    @Inject
    Context context;

    @Inject
    UserDao userDao;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.tv_live_screenname)
    TextView tvLiveScreenName;


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);
        loginPresenter = new LoginPresenter(getLifecycle(), this, userDao);

        getMutableScreenName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "logi*: " + getMutableScreenName().getValue());
            }
        });


        getMutableScreenName().setValue("$444");

    }

    @OnClick(R.id.btn_login)
    public void login() {
        User user = new User();
        user.setEmailId(etEmail.getText().toString());
        user.setPassword(etPwd.getText().toString());
        loginPresenter.requestLogin(user);


    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Successful * ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomePage.class));
        finish();

    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();
        mutableScreenName.setValue("loginfailed");

    }
}
