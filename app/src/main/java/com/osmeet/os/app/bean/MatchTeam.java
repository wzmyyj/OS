package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchTeam {

    private String id;
    private long matchEndTime;
    private long matchStartTime;
    private Store store;
    private MatchUnit unita;
    private MatchUnit unitb;
    private String togetherState;
    private int atimeStatus;
    private long awantMeetTime;
    private int btimeStatus;
    private long bwantMeetTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMatchEndTime(long matchEndTime) {
        this.matchEndTime = matchEndTime;
    }

    public long getMatchEndTime() {
        return matchEndTime;
    }

    public void setMatchStartTime(long matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    public long getMatchStartTime() {
        return matchStartTime;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setUnita(MatchUnit unita) {
        this.unita = unita;
    }

    public MatchUnit getUnita() {
        return unita;
    }

    public void setUnitb(MatchUnit unitb) {
        this.unitb = unitb;
    }

    public MatchUnit getUnitb() {
        return unitb;
    }


    public String getTogetherState() {
        return togetherState;
    }

    public void setTogetherState(String togetherState) {
        this.togetherState = togetherState;
    }

    public int getAtimeStatus() {
        return atimeStatus;
    }

    public void setAtimeStatus(int atimeStatus) {
        this.atimeStatus = atimeStatus;
    }

    public long getAwantMeetTime() {
        return awantMeetTime;
    }

    public void setAwantMeetTime(long awantMeetTime) {
        this.awantMeetTime = awantMeetTime;
    }

    public int getBtimeStatus() {
        return btimeStatus;
    }

    public void setBtimeStatus(int btimeStatus) {
        this.btimeStatus = btimeStatus;
    }

    public long getBwantMeetTime() {
        return bwantMeetTime;
    }

    public void setBwantMeetTime(long bwantMeetTime) {
        this.bwantMeetTime = bwantMeetTime;
    }
}
