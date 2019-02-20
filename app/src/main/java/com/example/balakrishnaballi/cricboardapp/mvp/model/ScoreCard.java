package com.example.balakrishnaballi.cricboardapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ScoreCard implements Serializable {

    @SerializedName("dateTimeGMT")
    @Expose
    private String dateTimeGMT;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("cache3")
    @Expose
    private boolean cache3;
    @SerializedName("creditsLeft")
    @Expose
    private int creditsLeft;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("provider")
    @Expose
    private Provider provider;

    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCache3() {
        return cache3;
    }

    public void setCache3(boolean cache3) {
        this.cache3 = cache3;
    }

    public int getCreditsLeft() {
        return creditsLeft;
    }

    public void setCreditsLeft(int creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public class Batting implements Serializable {

        @SerializedName("scores")
        @Expose
        private List<Score__> scores = null;
        @SerializedName("title")
        @Expose
        private String title;

        public List<Score__> getScores() {
            return scores;
        }

        public void setScores(List<Score__> scores) {
            this.scores = scores;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }


    public class Bowling implements Serializable {

        @SerializedName("scores")
        @Expose
        private List<Score_> scores = null;
        @SerializedName("title")
        @Expose
        private String title;

        public List<Score_> getScores() {
            return scores;
        }

        public void setScores(List<Score_> scores) {
            this.scores = scores;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }


    public class Data implements Serializable {

        @SerializedName("fielding")
        @Expose
        private List<Fielding> fielding = null;
        @SerializedName("bowling")
        @Expose
        private List<Bowling> bowling = null;
        @SerializedName("batting")
        @Expose
        private List<Batting> batting = null;
        @SerializedName("team")
        @Expose
        private List<Team> team = null;
        /*  @SerializedName("man-of-the-match")
          @Expose
          private ManOfTheMatch manOfTheMatch;*/
        @SerializedName("toss_winner_team")
        @Expose
        private String tossWinnerTeam;
        @SerializedName("winner_team")
        @Expose
        private String winnerTeam;
        @SerializedName("matchStarted")
        @Expose
        private boolean matchStarted;

        public List<Fielding> getFielding() {
            return fielding;
        }

        public void setFielding(List<Fielding> fielding) {
            this.fielding = fielding;
        }

        public List<Bowling> getBowling() {
            return bowling;
        }

        public void setBowling(List<Bowling> bowling) {
            this.bowling = bowling;
        }

        public List<Batting> getBatting() {
            return batting;
        }

        public void setBatting(List<Batting> batting) {
            this.batting = batting;
        }

        public List<Team> getTeam() {
            return team;
        }

        public void setTeam(List<Team> team) {
            this.team = team;
        }
/*
        public ManOfTheMatch getManOfTheMatch() {
            return manOfTheMatch;
        }

        public void setManOfTheMatch(ManOfTheMatch manOfTheMatch) {
            this.manOfTheMatch = manOfTheMatch;
        }*/

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


    public class DismissalBy implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("pid")
        @Expose
        private String pid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

    }


    public class Fielding implements Serializable {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("scores")
        @Expose
        private List<Score> scores = null;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Score> getScores() {
            return scores;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

    }


    public class ManOfTheMatch implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("pid")
        @Expose
        private String pid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

    }

    public class Player implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("pid")
        @Expose
        private String pid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

    }


    public class Provider implements Serializable {

        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("pubDate")
        @Expose
        private String pubDate;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

    }


    public class Score implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("runout")
        @Expose
        private int runout;
        @SerializedName("stumped")
        @Expose
        private int stumped;
        @SerializedName("bowled")
        @Expose
        private int bowled;
        @SerializedName("lbw")
        @Expose
        private int lbw;
        @SerializedName("catch")
        @Expose
        private int _catch;
        @SerializedName("pid")
        @Expose
        private String pid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRunout() {
            return runout;
        }

        public void setRunout(int runout) {
            this.runout = runout;
        }

        public int getStumped() {
            return stumped;
        }

        public void setStumped(int stumped) {
            this.stumped = stumped;
        }

        public int getBowled() {
            return bowled;
        }

        public void setBowled(int bowled) {
            this.bowled = bowled;
        }

        public int getLbw() {
            return lbw;
        }

        public void setLbw(int lbw) {
            this.lbw = lbw;
        }

        public int getCatch() {
            return _catch;
        }

        public void setCatch(int _catch) {
            this._catch = _catch;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

    }


    public class Score_ implements Serializable {

        @SerializedName("6s")
        @Expose
        private int _6s;
        @SerializedName("4s")
        @Expose
        private int _4s;
        @SerializedName("0s")
        @Expose
        private int _0s;
        @SerializedName("Econ")
        @Expose
        private String econ;
        @SerializedName("W")
        @Expose
        private String w;
        @SerializedName("R")
        @Expose
        private String r;
        @SerializedName("M")
        @Expose
        private String m;
        @SerializedName("O")
        @Expose
        private String o;
        @SerializedName("bowler")
        @Expose
        private String bowler;
        @SerializedName("pid")
        @Expose
        private String pid;

        public int get6s() {
            return _6s;
        }

        public void set6s(int _6s) {
            this._6s = _6s;
        }

        public int get4s() {
            return _4s;
        }

        public void set4s(int _4s) {
            this._4s = _4s;
        }

        public int get0s() {
            return _0s;
        }

        public void set0s(int _0s) {
            this._0s = _0s;
        }

        public String getEcon() {
            return econ;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public String getW() {
            return w;
        }

        public void setW(String w) {
            this.w = w;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }

        public String getO() {
            return o;
        }

        public void setO(String o) {
            this.o = o;
        }

        public String getBowler() {
            return bowler;
        }

        public void setBowler(String bowler) {
            this.bowler = bowler;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

    }


    public class Score__ implements Serializable {

        /*  @SerializedName("dismissal-by")
          @Expose
          private DismissalBy dismissalBy;*/
        @SerializedName("dismissal")
        @Expose
        private String dismissal;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("6s")
        @Expose
        private String _6s;
        @SerializedName("4s")
        @Expose
        private String _4s;
        @SerializedName("B")
        @Expose
        private String b;
        @SerializedName("R")
        @Expose
        private String r;
        @SerializedName("dismissal-info")
        @Expose
        private String dismissalInfo;
        @SerializedName("batsman")
        @Expose
        private String batsman;
        @SerializedName("pid")
        @Expose
        private int pid;
        @SerializedName("detail")
        @Expose
        private String detail;

      /*  public DismissalBy getDismissalBy() {
            return dismissalBy;
        }

        public void setDismissalBy(DismissalBy dismissalBy) {
            this.dismissalBy = dismissalBy;
        }*/

        public String getDismissal() {
            return dismissal;
        }

        public void setDismissal(String dismissal) {
            this.dismissal = dismissal;
        }

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String get6s() {
            return _6s;
        }

        public void set6s(String _6s) {
            this._6s = _6s;
        }

        public String get4s() {
            return _4s;
        }

        public void set4s(String _4s) {
            this._4s = _4s;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getDismissalInfo() {
            return dismissalInfo;
        }

        public void setDismissalInfo(String dismissalInfo) {
            this.dismissalInfo = dismissalInfo;
        }

        public String getBatsman() {
            return batsman;
        }

        public void setBatsman(String batsman) {
            this.batsman = batsman;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

    }


    public class Team implements Serializable {

        @SerializedName("players")
        @Expose
        private List<Player> players = null;
        @SerializedName("name")
        @Expose
        private String name;

        public List<Player> getPlayers() {
            return players;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
