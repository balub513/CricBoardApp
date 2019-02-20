package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.mvp.view.adapter.BattingAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreDetailedActivity extends AppCompatActivity {

    boolean isBatting1, isBatting2, isBowling1, isBowling2, isTeam1, isTeam2;

    List<ScoreCard.Score__> battingList = new ArrayList<ScoreCard.Score__>();
    private ScoreCard.Data data;

    @BindView(R.id.reclyerview)
    RecyclerView recyclerView;
    private BattingAdapter battingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_detailed);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            data = (ScoreCard.Data) extras.getSerializable(Consts.Network.DATA);
            isBatting1 = extras.getBoolean(Consts.Network.BATTING1);
            isBatting2 = extras.getBoolean(Consts.Network.BATTING2);
        }

        populateData();
    }

    private void populateData() {
        battingAdapter = new BattingAdapter(this, this, battingList);
        recyclerView.setAdapter(battingAdapter);
        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        if (isBatting1) {
            List<ScoreCard.Score__> list = data.getBatting().get(0).getScores();
            battingList.clear();
            battingList.addAll(list);
            battingAdapter.notifyDataSetChanged();
        }
    }
}
