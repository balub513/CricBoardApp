package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Match;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Matches;
import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.UpcomingMatchesPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingMatchesActivity extends AppCompatActivity implements view.UpcomingMatchesView, MatchesAdapter.ItemClickListener {

    ArrayList<Match> matches = new ArrayList<Match>();
    private MatchesAdapter matchesAdapter;

    @BindView(R.id.recyclerview_matches)
    RecyclerView recyclerView;

    @Inject
    CricApi cricApi;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_matches);

        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);

        startLoading();

        new UpcomingMatchesPresenter(getLifecycle(), this, cricApi).requestUpcomingCricketMatches();
        matchesAdapter = new MatchesAdapter(this, matches);


        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(matchesAdapter);
    }

    public void startLoading() {
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("loading..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
    }

    public void dismissLoading() {
        progressBar.dismiss();
    }

    @Override
    public void sendBackUpcomingMathces(List<Match> upcomingMatches) {
        Toast.makeText(this, "Upcoming Mathces Fetched successfully", Toast.LENGTH_SHORT).show();
        dismissLoading();
        matches.clear();
        matches.addAll(upcomingMatches);
        matchesAdapter.notifyDataSetChanged();

    }

    @Override
    public void sendErrorReport(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        dismissLoading();

    }

    @Override
    public void OnCardClick(int pos) {
        Intent intent = new Intent(this, ScoreCardActivity.class);
        intent.putExtra(Consts.Network.UNIQUE_ID, matches.get(pos).getUniqueId() + "");
        startActivity(intent);

    }
}
