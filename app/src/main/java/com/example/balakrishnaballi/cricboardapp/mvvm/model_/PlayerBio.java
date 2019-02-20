package com.example.balakrishnaballi.cricboardapp.mvvm.model_;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerBio {


    @SerializedName("pid")
    @Expose
    private int pid;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("battingStyle")
    @Expose
    private String battingStyle;
    @SerializedName("bowlingStyle")
    @Expose
    private String bowlingStyle;
    @SerializedName("majorTeams")
    @Expose
    private String majorTeams;
    @SerializedName("currentAge")
    @Expose
    private String currentAge;
    @SerializedName("born")
    @Expose
    private String born;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playingRole")
    @Expose
    private Object playingRole;
    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("ttl")
    @Expose
    private int ttl;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("creditsLeft")
    @Expose
    private int creditsLeft;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public String getMajorTeams() {
        return majorTeams;
    }

    public void setMajorTeams(String majorTeams) {
        this.majorTeams = majorTeams;
    }

    public String getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(String currentAge) {
        this.currentAge = currentAge;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
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

    public Object getPlayingRole() {
        return playingRole;
    }

    public void setPlayingRole(Object playingRole) {
        this.playingRole = playingRole;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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


    public class Batting {

        @SerializedName("listA")
        @Expose
        private ListA_ listA;
        @SerializedName("firstClass")
        @Expose
        private FirstClass_ firstClass;
        @SerializedName("ODIs")
        @Expose
        private ODIs_ oDIs;
        @SerializedName("tests")
        @Expose
        private Tests_ tests;

        public ListA_ getListA() {
            return listA;
        }

        public void setListA(ListA_ listA) {
            this.listA = listA;
        }

        public FirstClass_ getFirstClass() {
            return firstClass;
        }

        public void setFirstClass(FirstClass_ firstClass) {
            this.firstClass = firstClass;
        }

        public ODIs_ getODIs() {
            return oDIs;
        }

        public void setODIs(ODIs_ oDIs) {
            this.oDIs = oDIs;
        }

        public Tests_ getTests() {
            return tests;
        }

        public void setTests(Tests_ tests) {
            this.tests = tests;
        }

    }

    public class Bowling {

        @SerializedName("listA")
        @Expose
        private ListA listA;
        @SerializedName("firstClass")
        @Expose
        private FirstClass firstClass;
        @SerializedName("ODIs")
        @Expose
        private ODIs oDIs;
        @SerializedName("tests")
        @Expose
        private Tests tests;

        public ListA getListA() {
            return listA;
        }

        public void setListA(ListA listA) {
            this.listA = listA;
        }

        public FirstClass getFirstClass() {
            return firstClass;
        }

        public void setFirstClass(FirstClass firstClass) {
            this.firstClass = firstClass;
        }

        public ODIs getODIs() {
            return oDIs;
        }

        public void setODIs(ODIs oDIs) {
            this.oDIs = oDIs;
        }

        public Tests getTests() {
            return tests;
        }

        public void setTests(Tests tests) {
            this.tests = tests;
        }

    }

    public class Data {

        @SerializedName("bowling")
        @Expose
        private Bowling bowling;
        @SerializedName("batting")
        @Expose
        private Batting batting;

        public Bowling getBowling() {
            return bowling;
        }

        public void setBowling(Bowling bowling) {
            this.bowling = bowling;
        }

        public Batting getBatting() {
            return batting;
        }

        public void setBatting(Batting batting) {
            this.batting = batting;
        }

    }

    public class FirstClass {

        @SerializedName("10")
        @Expose
        private String _10;
        @SerializedName("5w")
        @Expose
        private String _5w;
        @SerializedName("4w")
        @Expose
        private String _4w;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("Econ")
        @Expose
        private String econ;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("BBM")
        @Expose
        private String bBM;
        @SerializedName("BBI")
        @Expose
        private String bBI;
        @SerializedName("Wkts")
        @Expose
        private String wkts;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("Balls")
        @Expose
        private String balls;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get10() {
            return _10;
        }

        public void set10(String _10) {
            this._10 = _10;
        }

        public String get5w() {
            return _5w;
        }

        public void set5w(String _5w) {
            this._5w = _5w;
        }

        public String get4w() {
            return _4w;
        }

        public void set4w(String _4w) {
            this._4w = _4w;
        }

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getEcon() {
            return econ;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getBBM() {
            return bBM;
        }

        public void setBBM(String bBM) {
            this.bBM = bBM;
        }

        public String getBBI() {
            return bBI;
        }

        public void setBBI(String bBI) {
            this.bBI = bBI;
        }

        public String getWkts() {
            return wkts;
        }

        public void setWkts(String wkts) {
            this.wkts = wkts;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getBalls() {
            return balls;
        }

        public void setBalls(String balls) {
            this.balls = balls;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class FirstClass_ {

        @SerializedName("50")
        @Expose
        private String _50;
        @SerializedName("100")
        @Expose
        private String _100;
        @SerializedName("St")
        @Expose
        private String st;
        @SerializedName("Ct")
        @Expose
        private String ct;
        @SerializedName("6s")
        @Expose
        private String _6s;
        @SerializedName("4s")
        @Expose
        private String _4s;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("BF")
        @Expose
        private String bF;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("HS")
        @Expose
        private String hS;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("NO")
        @Expose
        private String nO;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get50() {
            return _50;
        }

        public void set50(String _50) {
            this._50 = _50;
        }

        public String get100() {
            return _100;
        }

        public void set100(String _100) {
            this._100 = _100;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
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

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getBF() {
            return bF;
        }

        public void setBF(String bF) {
            this.bF = bF;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getHS() {
            return hS;
        }

        public void setHS(String hS) {
            this.hS = hS;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getNO() {
            return nO;
        }

        public void setNO(String nO) {
            this.nO = nO;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class ListA {

        @SerializedName("10")
        @Expose
        private String _10;
        @SerializedName("5w")
        @Expose
        private String _5w;
        @SerializedName("4w")
        @Expose
        private String _4w;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("Econ")
        @Expose
        private String econ;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("BBM")
        @Expose
        private String bBM;
        @SerializedName("BBI")
        @Expose
        private String bBI;
        @SerializedName("Wkts")
        @Expose
        private String wkts;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("Balls")
        @Expose
        private String balls;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get10() {
            return _10;
        }

        public void set10(String _10) {
            this._10 = _10;
        }

        public String get5w() {
            return _5w;
        }

        public void set5w(String _5w) {
            this._5w = _5w;
        }

        public String get4w() {
            return _4w;
        }

        public void set4w(String _4w) {
            this._4w = _4w;
        }

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getEcon() {
            return econ;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getBBM() {
            return bBM;
        }

        public void setBBM(String bBM) {
            this.bBM = bBM;
        }

        public String getBBI() {
            return bBI;
        }

        public void setBBI(String bBI) {
            this.bBI = bBI;
        }

        public String getWkts() {
            return wkts;
        }

        public void setWkts(String wkts) {
            this.wkts = wkts;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getBalls() {
            return balls;
        }

        public void setBalls(String balls) {
            this.balls = balls;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class ListA_ {

        @SerializedName("50")
        @Expose
        private String _50;
        @SerializedName("100")
        @Expose
        private String _100;
        @SerializedName("St")
        @Expose
        private String st;
        @SerializedName("Ct")
        @Expose
        private String ct;
        @SerializedName("6s")
        @Expose
        private String _6s;
        @SerializedName("4s")
        @Expose
        private String _4s;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("BF")
        @Expose
        private String bF;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("HS")
        @Expose
        private String hS;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("NO")
        @Expose
        private String nO;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get50() {
            return _50;
        }

        public void set50(String _50) {
            this._50 = _50;
        }

        public String get100() {
            return _100;
        }

        public void set100(String _100) {
            this._100 = _100;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
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

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getBF() {
            return bF;
        }

        public void setBF(String bF) {
            this.bF = bF;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getHS() {
            return hS;
        }

        public void setHS(String hS) {
            this.hS = hS;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getNO() {
            return nO;
        }

        public void setNO(String nO) {
            this.nO = nO;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class ODIs {

        @SerializedName("10")
        @Expose
        private String _10;
        @SerializedName("5w")
        @Expose
        private String _5w;
        @SerializedName("4w")
        @Expose
        private String _4w;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("Econ")
        @Expose
        private String econ;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("BBM")
        @Expose
        private String bBM;
        @SerializedName("BBI")
        @Expose
        private String bBI;
        @SerializedName("Wkts")
        @Expose
        private String wkts;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("Balls")
        @Expose
        private String balls;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get10() {
            return _10;
        }

        public void set10(String _10) {
            this._10 = _10;
        }

        public String get5w() {
            return _5w;
        }

        public void set5w(String _5w) {
            this._5w = _5w;
        }

        public String get4w() {
            return _4w;
        }

        public void set4w(String _4w) {
            this._4w = _4w;
        }

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getEcon() {
            return econ;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getBBM() {
            return bBM;
        }

        public void setBBM(String bBM) {
            this.bBM = bBM;
        }

        public String getBBI() {
            return bBI;
        }

        public void setBBI(String bBI) {
            this.bBI = bBI;
        }

        public String getWkts() {
            return wkts;
        }

        public void setWkts(String wkts) {
            this.wkts = wkts;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getBalls() {
            return balls;
        }

        public void setBalls(String balls) {
            this.balls = balls;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class ODIs_ {

        @SerializedName("50")
        @Expose
        private String _50;
        @SerializedName("100")
        @Expose
        private String _100;
        @SerializedName("St")
        @Expose
        private String st;
        @SerializedName("Ct")
        @Expose
        private String ct;
        @SerializedName("6s")
        @Expose
        private String _6s;
        @SerializedName("4s")
        @Expose
        private String _4s;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("BF")
        @Expose
        private String bF;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("HS")
        @Expose
        private String hS;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("NO")
        @Expose
        private String nO;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get50() {
            return _50;
        }

        public void set50(String _50) {
            this._50 = _50;
        }

        public String get100() {
            return _100;
        }

        public void set100(String _100) {
            this._100 = _100;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
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

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getBF() {
            return bF;
        }

        public void setBF(String bF) {
            this.bF = bF;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getHS() {
            return hS;
        }

        public void setHS(String hS) {
            this.hS = hS;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getNO() {
            return nO;
        }

        public void setNO(String nO) {
            this.nO = nO;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
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

    public class Tests {

        @SerializedName("10")
        @Expose
        private String _10;
        @SerializedName("5w")
        @Expose
        private String _5w;
        @SerializedName("4w")
        @Expose
        private String _4w;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("Econ")
        @Expose
        private String econ;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("BBM")
        @Expose
        private String bBM;
        @SerializedName("BBI")
        @Expose
        private String bBI;
        @SerializedName("Wkts")
        @Expose
        private String wkts;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("Balls")
        @Expose
        private String balls;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get10() {
            return _10;
        }

        public void set10(String _10) {
            this._10 = _10;
        }

        public String get5w() {
            return _5w;
        }

        public void set5w(String _5w) {
            this._5w = _5w;
        }

        public String get4w() {
            return _4w;
        }

        public void set4w(String _4w) {
            this._4w = _4w;
        }

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getEcon() {
            return econ;
        }

        public void setEcon(String econ) {
            this.econ = econ;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getBBM() {
            return bBM;
        }

        public void setBBM(String bBM) {
            this.bBM = bBM;
        }

        public String getBBI() {
            return bBI;
        }

        public void setBBI(String bBI) {
            this.bBI = bBI;
        }

        public String getWkts() {
            return wkts;
        }

        public void setWkts(String wkts) {
            this.wkts = wkts;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getBalls() {
            return balls;
        }

        public void setBalls(String balls) {
            this.balls = balls;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }

    public class Tests_ {

        @SerializedName("50")
        @Expose
        private String _50;
        @SerializedName("100")
        @Expose
        private String _100;
        @SerializedName("St")
        @Expose
        private String st;
        @SerializedName("Ct")
        @Expose
        private String ct;
        @SerializedName("6s")
        @Expose
        private String _6s;
        @SerializedName("4s")
        @Expose
        private String _4s;
        @SerializedName("SR")
        @Expose
        private String sR;
        @SerializedName("BF")
        @Expose
        private String bF;
        @SerializedName("Ave")
        @Expose
        private String ave;
        @SerializedName("HS")
        @Expose
        private String hS;
        @SerializedName("Runs")
        @Expose
        private String runs;
        @SerializedName("NO")
        @Expose
        private String nO;
        @SerializedName("Inns")
        @Expose
        private String inns;
        @SerializedName("Mat")
        @Expose
        private String mat;

        public String get50() {
            return _50;
        }

        public void set50(String _50) {
            this._50 = _50;
        }

        public String get100() {
            return _100;
        }

        public void set100(String _100) {
            this._100 = _100;
        }

        public String getSt() {
            return st;
        }

        public void setSt(String st) {
            this.st = st;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
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

        public String getSR() {
            return sR;
        }

        public void setSR(String sR) {
            this.sR = sR;
        }

        public String getBF() {
            return bF;
        }

        public void setBF(String bF) {
            this.bF = bF;
        }

        public String getAve() {
            return ave;
        }

        public void setAve(String ave) {
            this.ave = ave;
        }

        public String getHS() {
            return hS;
        }

        public void setHS(String hS) {
            this.hS = hS;
        }

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getNO() {
            return nO;
        }

        public void setNO(String nO) {
            this.nO = nO;
        }

        public String getInns() {
            return inns;
        }

        public void setInns(String inns) {
            this.inns = inns;
        }

        public String getMat() {
            return mat;
        }

        public void setMat(String mat) {
            this.mat = mat;
        }

    }
}
