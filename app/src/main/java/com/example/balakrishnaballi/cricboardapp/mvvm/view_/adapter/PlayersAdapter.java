package com.example.balakrishnaballi.cricboardapp.mvvm.view_.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerFinder;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder> {

    private final Context context;
    private List<PlayerFinder.Datum> listPlayers;
    private onItemClickListener listener;

    public PlayersAdapter(Context context, List<PlayerFinder.Datum> listPlayers, onItemClickListener listener) {
        this.context = context;
        this.listPlayers = listPlayers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_player_item, null);
        PlayerViewHolder viewHolder = new PlayerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder playerViewHolder, int i) {
        playerViewHolder.tvPlayerName.setText(listPlayers.get(i).getFullName());
    }

    @Override
    public int getItemCount() {
        return listPlayers.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPlayerName;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerName = itemView.findViewById(R.id.tv_player_name);
            tvPlayerName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSerchPlayerClick(listPlayers
                            .get(getAdapterPosition()));
                }
            });
        }
    }

    public interface onItemClickListener {
        void onSerchPlayerClick(PlayerFinder.Datum player);
    }
}
