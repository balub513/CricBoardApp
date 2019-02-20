package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDataBase;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.SignupPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends BaseActivity implements view.SignupView {

    @Inject
    Context context;

    @Inject
    UserDao userDao;

    @Inject
    UserDataBase userDataBase;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_phno)
    EditText etPhone;

    @BindView(R.id.et_pwd)
    EditText etPwd;

    @BindView(R.id.btn_signup)
    Button btnSignup;

    @BindView(R.id.tv_live_screenname)
    TextView tvLiveScreenName;

    private static final String TAG = "SignupActivity";
    private SignupPresenter signupPresenter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);
        signupPresenter = new SignupPresenter(getLifecycle(), this, userDao);



    }

    @OnClick(R.id.btn_signup)
    public void signupUser() {
        user = new User();
        user.setName(etName.getText().toString());
        user.setEmailId(etEmail.getText().toString());
        user.setPhoneNumber(etPhone.getText().toString());
        user.setPassword(etPwd.getText().toString());
        signupPresenter.registerUser(user);

    }

    @Override
    public void registraionSuccessful() {

        Toast.makeText(this, user.getName() + " registered successfully", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void errorInRegistraion() {
        Toast.makeText(this, "Failure Registraion", Toast.LENGTH_SHORT).show();
    }
}
