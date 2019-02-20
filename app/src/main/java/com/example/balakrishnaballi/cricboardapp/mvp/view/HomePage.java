package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerFinder;
import com.example.balakrishnaballi.cricboardapp.mvvm.view_.PlayerFinderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePage extends AppCompatActivity {

    @BindView(R.id.tv_old_matches)
    TextView tvOldMatches;

    @BindView(R.id.tv_upcoming_matches)
    TextView tvUpcomingMatches;

    @BindView(R.id.tv_player_bio)
    TextView tvPlayeBio;

    @BindView(R.id.tv_player_finder)
    TextView tvPlayerFinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_old_matches)
    public void oldMatches() {
        startActivity(new Intent(this, UpcomingMatchesActivity.class));
    }

    @OnClick(R.id.tv_upcoming_matches)
    public void upComingMatches() {
        startActivity(new Intent(this, OldMatchesActivity.class));

    }

    @OnClick(R.id.tv_player_bio)
    public void playerBio() {
        startActivity(new Intent(this, PlayerFinderActivity.class));
    }

    @OnClick(R.id.tv_player_finder)
    public void playerFinder() {
        startActivity(new Intent(this, PlayerFinderActivity.class));
    }
}
