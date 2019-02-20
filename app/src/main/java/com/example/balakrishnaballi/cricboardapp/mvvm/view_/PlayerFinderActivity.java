package com.example.balakrishnaballi.cricboardapp.mvvm.view_;

import android.app.ProgressDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerFinder;
import com.example.balakrishnaballi.cricboardapp.mvvm.view_.adapter.PlayersAdapter;
import com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_.PlayerFinderViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerFinderActivity extends AppCompatActivity {

    private PlayerFinderViewModel viewModel;
    private LiveData<PlayerFinder> player;

    @BindView(R.id.et_search_player)
    EditText etSearchPlayer;

    @BindView(R.id.iv_search)
    ImageView btnSearch;

    @BindView(R.id.rv_player_search_list)
    RecyclerView recyclerView;

    List<PlayerFinder.Datum> playersList = new ArrayList<PlayerFinder.Datum>();
    private PlayersAdapter adapter;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_finder);
        ButterKnife.bind(this);

        CricboardApplication.getMyCricboardAppComponent().inject(this);

        viewModel = ViewModelProviders.of(this).get(PlayerFinderViewModel.class);

        adapter = new PlayersAdapter(this, playersList, new ItemClick());

        LinearLayoutManager mLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);


    }

    @OnClick(R.id.iv_search)
    public void searchClick() {
        startLoading();
        String playerName = etSearchPlayer.getText().toString();
        player = viewModel.getPlayersListBySearch(playerName);

        player.observe(this, new Observer<PlayerFinder>() {
            @Override
            public void onChanged(@Nullable PlayerFinder player) {
                List<PlayerFinder.Datum> list = player.getData();
                notifyAdapter(list);
                dismissLoading();
            }
        });
    }

    public void notifyAdapter(List<PlayerFinder.Datum> list) {
        playersList.clear();
        playersList.addAll(list);
        adapter.notifyDataSetChanged();
    }


    private class ItemClick implements PlayersAdapter.onItemClickListener {

        @Override
        public void onSerchPlayerClick(PlayerFinder.Datum player) {
            Toast.makeText(getApplicationContext(), player.getFullName() + " : " + player.getPid(),
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PlayerFinderActivity.this, PlayerBioActivity.class);
            intent.putExtra(Consts.Network.PLAYER_ID, player.getPid());
            startActivity(intent);
        }
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
