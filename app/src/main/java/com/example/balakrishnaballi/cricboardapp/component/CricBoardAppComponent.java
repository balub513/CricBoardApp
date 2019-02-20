package com.example.balakrishnaballi.cricboardapp.component;

import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.module.AppModule;
import com.example.balakrishnaballi.cricboardapp.module.DbModule;
import com.example.balakrishnaballi.cricboardapp.module.NetworkModule;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.UpcomingMatchesPresenter;
import com.example.balakrishnaballi.cricboardapp.mvp.view.LoginActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.MainActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.MatchesAdapter;
import com.example.balakrishnaballi.cricboardapp.mvp.view.OldMatchesActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.RegisteredUsersListActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.ScoreCardActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.SignupActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.UpcomingMatchesActivity;
import com.example.balakrishnaballi.cricboardapp.mvp.view.adapter.OldMatchesAdapter;
import com.example.balakrishnaballi.cricboardapp.mvvm.view_.PlayerFinderActivity;
import com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_.PlayBioViewModel;
import com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_.PlayerFinderViewModel;

import dagger.Component;

@Component(modules = {AppModule.class, NetworkModule.class, DbModule.class})
public interface CricBoardAppComponent {

    void inject(SignupActivity signupActivity);

    void inject(LoginActivity loginActivity);

    void inject(RegisteredUsersListActivity usersListActivity);

    void inject(MainActivity mainActivity);

    void inject(UpcomingMatchesActivity upcomingMatchesActivity);

    void inject(OldMatchesActivity oldMatchesActivity);

    void inject(ScoreCardActivity scoreCardActivity);


    void inject(MatchesAdapter matchesAdapter);

    void inject(OldMatchesAdapter oldMatchesAdapter);


    void inject(PlayerFinderActivity playerFinderActivity);

    void inject(PlayerFinderViewModel playerFinderViewModel);

    void inject(PlayBioViewModel playBioViewModel);

}
