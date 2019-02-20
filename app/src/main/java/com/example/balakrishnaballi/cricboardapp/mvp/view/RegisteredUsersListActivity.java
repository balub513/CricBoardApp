package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.UsersListPresenter;
import com.example.balakrishnaballi.cricboardapp.mvp.view.adapter.UsersListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisteredUsersListActivity extends AppCompatActivity implements view.UsersListView {

    @Inject
    Context context;

    @Inject
    UserDao userDao;
    private UsersListPresenter usersListPresenter;

    List<User> listUsers = new ArrayList<User>();
    private UsersListAdapter usersListAdapter;

    @BindView(R.id.rv_users)
    RecyclerView recyclerView;

    @BindView(R.id.bt_adduser)
    Button btnAddUder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_users_list);
        CricboardApplication.getMyCricboardAppComponent().inject(this);

        ButterKnife.bind(this);

        usersListPresenter = new UsersListPresenter(this, getLifecycle(), this, userDao);
        usersListPresenter.getRegisteredUsers();

        usersListAdapter = new UsersListAdapter(this, listUsers);

        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(usersListAdapter);

    }

    @OnClick(R.id.bt_adduser)
    public void addUser() {
        User user = new User();
        user.setName("Balu:" + Math.random());
        user.setEmailId("email@" + Math.random());
        user.setPassword("111");
        user.setPhoneNumber("897978");
        usersListPresenter.addUser(user);

    }

    @Override
    public void sendBackusersList(List<User> userList) {
        Toast.makeText(this, "Users list fetched successful :" + userList.size(), Toast.LENGTH_SHORT).show();
        listUsers.clear();
        listUsers.addAll(userList);
        usersListAdapter.notifyDataSetChanged();

    }

    @Override
    public void sendError(String err) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void addUserSuccessful() {
        Toast.makeText(this, "added Random user successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addUserFailure() {
        Toast.makeText(this, "added Random user Faiulre", Toast.LENGTH_SHORT).show();

    }
}
