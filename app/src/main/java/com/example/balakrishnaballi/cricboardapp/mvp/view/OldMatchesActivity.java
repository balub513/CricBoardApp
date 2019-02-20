package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.network.CricApi;
import com.example.balakrishnaballi.cricboardapp.mvp.presenter.OldMatchesPresenter;
import com.example.balakrishnaballi.cricboardapp.mvp.view.adapter.OldMatchesAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OldMatchesActivity extends AppCompatActivity implements view.OldMatchesView, OldMatchesAdapter.OldMatchItemClick {

    @Inject
    Context context;

    @Inject
    CricApi cricApi;


    @BindView(R.id.recyclerview_matches)
    RecyclerView recyclerView;

    ArrayList<OldMatches.MatchSummary> list = new ArrayList<OldMatches.MatchSummary>();
    private OldMatchesAdapter adapter;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_matches);

        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);

        startLoading();
        new OldMatchesPresenter(getLifecycle(), this, cricApi).requestOldMatches();

        adapter = new OldMatchesAdapter(this, list);

        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void sendBackOldMathces(List<OldMatches.MatchSummary> listMatchSummaries) {
        dismissLoading();
        Toast.makeText(this, "OLD Mathces Fetched successfully", Toast.LENGTH_SHORT).show();
        list.clear();
        list.addAll(listMatchSummaries);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void sendbackErrorResponse(String errorMsg) {
        dismissLoading();
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(int pos) {
        OldMatches.MatchSummary matchSummary = list.get(pos);
        String uniqueId = matchSummary.getUniqueId();

        Intent intent = new Intent(this, ScoreCardActivity.class);
        intent.putExtra(Consts.Network.UNIQUE_ID, uniqueId);
        startActivity(intent);

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
