package com.example.balakrishnaballi.cricboardapp;

import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.UserDao;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.LoginPresenter;
import com.example.balakrishnaballi.cricboardapp.mvp.view.view;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {
    /*
     To test Presenter API,we have to comment Android Components so before test we have to comment
     "observeOn(AndroidSchedulers.mainThread())" inside requestLogin().
      */
    @Test
    public void testLogin() {

        UserDao mock = mock(UserDao.class);
        view.LoginView loginView = mock(view.LoginView.class);

        List<User> userList = getListOfRegisteredUsers();
        User inputUser = inputUser();

        LoginPresenter loginPresenter = new LoginPresenter(null, loginView, mock);

        when(mock.getUsers()).thenReturn(Single.just(userList));

        loginPresenter.requestLogin(inputUser);

        verify(loginView).loginSuccess();

    }

    public User inputUser() {
        User user = new User();
        user.setEmailId("1balu@gmail.com");
        user.setPassword("1234");
        return user;
    }

    public List<User> getListOfRegisteredUsers() {
        List<User> list = new ArrayList<User>();

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("Balu:" + i);
            user.setPassword("1234");
            user.setPhoneNumber("1233" + i);
            user.setEmailId(i + "balu@gmail.com");
            list.add(user);

        }
        return list;
    }

}
