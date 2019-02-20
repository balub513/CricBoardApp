package com.example.balakrishnaballi.cricboardapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

        @SerializedName("unique_id")
        @Expose
        private int uniqueId;
        @SerializedName("team-2")
        @Expose
        private String team2;
        @SerializedName("team-1")
        @Expose
        private String team1;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("dateTimeGMT")
        @Expose
        private String dateTimeGMT;
        @SerializedName("squad")
        @Expose
        private boolean squad;
        @SerializedName("toss_winner_team")
        @Expose
        private String tossWinnerTeam;
        @SerializedName("winner_team")
        @Expose
        private String winnerTeam;
        @SerializedName("matchStarted")
        @Expose
        private boolean matchStarted;

        public int getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(int uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }

        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDateTimeGMT() {
            return dateTimeGMT;
        }

        public void setDateTimeGMT(String dateTimeGMT) {
            this.dateTimeGMT = dateTimeGMT;
        }

        public boolean isSquad() {
            return squad;
        }

        public void setSquad(boolean squad) {
            this.squad = squad;
        }

        public String getTossWinnerTeam() {
            return tossWinnerTeam;
        }

        public void setTossWinnerTeam(String tossWinnerTeam) {
            this.tossWinnerTeam = tossWinnerTeam;
        }

        public String getWinnerTeam() {
            return winnerTeam;
        }

        public void setWinnerTeam(String winnerTeam) {
            this.winnerTeam = winnerTeam;
        }

        public boolean isMatchStarted() {
            return matchStarted;
        }

        public void setMatchStarted(boolean matchStarted) {
            this.matchStarted = matchStarted;
        }

    }