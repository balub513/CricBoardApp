package com.example.balakrishnaballi.cricboardapp.mvvm.model_;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerFinder {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("cache3")
    @Expose
    private boolean cache3;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("creditsLeft")
    @Expose
    private int creditsLeft;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public boolean isCache3() {
        return cache3;
    }

    public void setCache3(boolean cache3) {
        this.cache3 = cache3;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
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


    public class Datum {

        @SerializedName("pid")
        @Expose
        private int pid;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("name")
        @Expose
        private String name;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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