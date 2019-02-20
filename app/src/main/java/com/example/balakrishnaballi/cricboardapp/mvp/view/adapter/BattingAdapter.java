package com.example.balakrishnaballi.cricboardapp.mvp.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.mvvm.view_.PlayerBioActivity;

import java.util.List;

public class BattingAdapter extends RecyclerView.Adapter<BattingAdapter.BattingViewHolder> {
    private Activity activity;
    private Context context;
    private List<ScoreCard.Score__> battingList;

    public BattingAdapter(Activity activity, Context context, List<ScoreCard.Score__> battingList) {
        this.activity = activity;
        this.context = context;
        this.battingList = battingList;
    }

    @NonNull
    @Override
    public BattingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_batting, null);
        BattingViewHolder viewHolder = new BattingViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BattingViewHolder battingViewHolder, int i) {
        battingViewHolder.tvBatsmanRuns.setText(battingList.get(i).getR() + " runs");
        battingViewHolder.tvBatsManName.setText(battingList.get(i).getBatsman());

    }

    @Override
    public int getItemCount() {
        return battingList.size();
    }

    public class BattingViewHolder extends RecyclerView.ViewHolder {
        TextView tvBatsManName, tvBatsmanRuns;

        public BattingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBatsManName = itemView.findViewById(R.id.tv_batsman_name);
            tvBatsmanRuns = itemView.findViewById(R.id.tv_batsman_runs);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, PlayerBioActivity.class);
                    int position = getAdapterPosition();
                    intent.putExtra(Consts.Network.PLAYER_ID, battingList.get(position).getPid());
                    context.startActivity(intent);
                }
            });
        }
    }
}
