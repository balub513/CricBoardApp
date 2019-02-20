package com.example.balakrishnaballi.cricboardapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OldMatches {

    @SerializedName("creditsLeft")
    @Expose
    private int creditsLeft;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("cache")
    @Expose
    private boolean cache;
    @SerializedName("data")
    @Expose
    private List<MatchSummary> data = null;
    @SerializedName("cache2")
    @Expose
    private boolean cache2;

    public int getCreditsLeft() {
        return creditsLeft;
    }

    public void setCreditsLeft(int creditsLeft) {
        this.creditsLeft = creditsLeft;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public List<MatchSummary> getData() {
        return data;
    }

    public void setData(List<MatchSummary> data) {
        this.data = data;
    }

    public boolean isCache2() {
        return cache2;
    }

    public void setCache2(boolean cache2) {
        this.cache2 = cache2;
    }


    public class MatchSummary {

        @SerializedName("unique_id")
        @Expose
        private String uniqueId;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("title")
        @Expose
        private String title;

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

    public class Provider {

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
}