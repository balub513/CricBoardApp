package com.example.balakrishnaballi.cricboardapp.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.application.CricboardApplication;
import com.example.balakrishnaballi.cricboardapp.mvp.model.Match;
import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.mvp.view.MatchesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class OldMatchesAdapter extends RecyclerView.Adapter<OldMatchesAdapter.MatchViewHolder> {

    @Inject
    Context context;

    private OldMatchItemClick oldMatchItemClick;
    private List<OldMatches.MatchSummary> list;

    public OldMatchesAdapter(OldMatchItemClick oldMatchItemClick, List<OldMatches.MatchSummary> list) {
        this.oldMatchItemClick = oldMatchItemClick;
        this.list = list;
        CricboardApplication.getMyCricboardAppComponent().inject(this);
    }

    @NonNull
    @Override
    public OldMatchesAdapter.MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.add_item_oldmathces_summary, null);
        OldMatchesAdapter.MatchViewHolder viewHolder = new OldMatchesAdapter.MatchViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OldMatchesAdapter.MatchViewHolder matchViewHolder, int pos) {
        matchViewHolder.tv_match_desc.setText(list.get(pos).getDescription() + "");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_match_desc;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_match_desc = itemView.findViewById(R.id.tv_match_desc);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_item:
                    oldMatchItemClick.onItemClick(getAdapterPosition());
                    break;
            }

        }
    }

    public interface OldMatchItemClick {
        void onItemClick(int pos);
    }
}