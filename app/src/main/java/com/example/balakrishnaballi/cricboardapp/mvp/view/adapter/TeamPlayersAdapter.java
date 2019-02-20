package com.example.balakrishnaballi.cricboardapp.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;

public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.TeamPlayerViewHolder> {

    private Context context;

    public TeamPlayersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TeamPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_batting, null);
        TeamPlayerViewHolder viewHolder = new TeamPlayerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamPlayerViewHolder teamPlayerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TeamPlayerViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerName;

        public TeamPlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerName = itemView.findViewById(R.id.tv_player_name);

        }
    }

}
