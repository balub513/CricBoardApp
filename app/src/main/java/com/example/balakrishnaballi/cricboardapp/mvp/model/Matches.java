
package com.example.balakrishnaballi.cricboardapp.mvp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Matches {

    @SerializedName("matches")
    @Expose
    private List<Match> matches = null;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("creditsLeft")
    @Expose
    private int creditsLeft;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
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

    public int getCreditsLeft() {
        return creditsLeft;
    }

    public void setCreditsLeft(int creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

}
