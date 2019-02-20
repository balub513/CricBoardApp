package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.ScoreCardPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScoreCardActivity extends AppCompatActivity implements view.ScorecardView {

    private static final String TAG = "ScoreCardActivity";

    @Inject
    Context context;

    @Inject
    CricApi cricApi;
    private ScoreCardPresenter scoreCardPresenter;


    @BindView(R.id.tv_match_title)
    TextView tvTitle;

    @BindView(R.id.tv_toss)
    TextView tvToss;

    @BindView(R.id.tv_win)
    TextView tvWin;

   /* @BindView(R.id.tv_man_of_the_match)
    TextView tvManOftheMatch;*/

    @BindView(R.id.tv_batting_one)
    TextView tvBattingTeam1;

    @BindView(R.id.tv_batting_two)
    TextView tvBattingTeam2;


    @BindView(R.id.tv_bowling_one)
    TextView tvBowling1;


    @BindView(R.id.tv_bowling_two)
    TextView tvBowling2;


    @BindView(R.id.tv_team_one_players)
    TextView tvTeamOnePlayers;


    @BindView(R.id.tv_team_two_players)
    TextView tvTwoPlayers;


    private ProgressDialog progressBar;
    private ScoreCard.Data matchData;


    private Intent intentDetailScoreCard;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard);
        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);
        Intent intent = getIntent();
        if (intent != null) {
            String unique_id = intent.getStringExtra(Consts.Network.UNIQUE_ID);
            scoreCardPresenter = new ScoreCardPresenter(getLifecycle(), this, cricApi);
            startLoading();
            scoreCardPresenter.requestScoreCard(unique_id);
        }
        intentDetailScoreCard = new Intent(this, ScoreDetailedActivity.class);
        bundle = new Bundle();

    }

    @Override
    public void senBackScoreCard(ScoreCard scoreCard) {
        dismissLoading();
        matchData = scoreCard.getData();
        Toast.makeText(this, "Scorecard received successfully", Toast.LENGTH_SHORT).show();

        tvTitle.setText(matchData.getTeam().get(0).getName() + "-VS- " + matchData.getTeam().get(0).getName());
        tvToss.setText("Toss: " + matchData.getTossWinnerTeam() + " Batting:" + matchData.getBatting().get(0).getTitle());
        tvWin.setText("WON: " + matchData.getWinnerTeam());
       // tvManOftheMatch.setText("Man of the Match: " + matchData.getManOfTheMatch());


    }


    @OnClick(R.id.tv_batting_one)
    public void teamOneBatting() {
        bundle.putSerializable(Consts.Network.DATA, matchData);
        bundle.putBoolean(Consts.Network.BATTING1, true);
        intentDetailScoreCard.putExtras(bundle);
        startActivity(intentDetailScoreCard);


    }

    @OnClick(R.id.tv_batting_two)
    public void team2Batting() {
        bundle.putSerializable(Consts.Network.DATA, matchData);
        bundle.putBoolean(Consts.Network.BATTING2, true);
        intentDetailScoreCard.putExtras(bundle);
        startActivity(intentDetailScoreCard);

    }

    @OnClick(R.id.tv_bowling_one)
    public void team1Bowling() {

    }

    @OnClick(R.id.tv_bowling_two)
    public void team2Bowling() {

    }

    @OnClick(R.id.tv_team_one_players)
    public void team1Players() {

    }

    @OnClick(R.id.tv_team_two_players)
    public void team2Players() {

    }


    @Override
    public void sendbackErrorResponse(String errorMsg) {
        dismissLoading();
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

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
}
