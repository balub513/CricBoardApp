package com.example.balakrishnaballi.cricboardapp.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;

public class BowlingAdapter extends RecyclerView.Adapter<BowlingAdapter.BowlingViewHolder> {

    private Context context;

    public BowlingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BowlingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_batting, null);
        BowlingViewHolder viewHolder = new BowlingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BowlingViewHolder bowlingViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BowlingViewHolder extends RecyclerView.ViewHolder {
        TextView tvBowlerName, tvBowlerWickets;

        public BowlingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBowlerName = itemView.findViewById(R.id.tv_bowler_name);
            tvBowlerWickets = itemView.findViewById(R.id.tv_bowler_wickets);

        }
    }
}
