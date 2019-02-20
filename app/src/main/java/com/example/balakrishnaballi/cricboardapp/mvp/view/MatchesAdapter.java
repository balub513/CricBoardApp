package com.example.balakrishnaballi.cricboardapp.mvp.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Match;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Matches;

import java.util.List;

import javax.inject.Inject;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    @Inject
    Context context;

    private ItemClickListener listener;
    private List<Match> list;

    public MatchesAdapter(ItemClickListener listener, List<Match> list) {
        this.listener = listener;
        this.list = list;
        CricboardApplication.getMyCricboardAppComponent().inject(this);
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.add_item_match, null);
        MatchViewHolder viewHolder = new MatchViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int pos) {
        if (list.get(pos).isMatchStarted()) {
            matchViewHolder.match1.setTextColor(Color.GREEN);
            matchViewHolder.match2.setTextColor(Color.GREEN);
            matchViewHolder.matchDate.setTextColor(Color.GREEN);
        }
        matchViewHolder.match1.setText(list.get(pos).getTeam1() + "");
        matchViewHolder.match2.setText(list.get(pos).getTeam2() + "");
        matchViewHolder.matchDate.setText(list.get(pos).getDate() + "");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MatchViewHolder extends ViewHolder implements View.OnClickListener {
        TextView match1, match2, matchDate;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            match1 = itemView.findViewById(R.id.tv_team_one);
            match2 = itemView.findViewById(R.id.tv_team_two);
            matchDate = itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_item:
                    listener.OnCardClick(getAdapterPosition());
                    break;
            }

        }
    }

    interface ItemClickListener {
        void OnCardClick(int pos);
    }
}
