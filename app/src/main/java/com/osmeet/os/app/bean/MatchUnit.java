package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchUnit {
    private String id;
    private int matchMode;
    private int matchStatus;
    private int matchUnitSize;
    private Store store;
    private User user;
    private long wantMeetTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMatchMode(int matchMode) {
        this.matchMode = matchMode;
    }

    public int getMatchMode() {
        return matchMode;
    }

    public void setMatchStatus(int matchStatus) {
        this.matchStatus = matchStatus;
    }

    public int getMatchStatus() {
        return matchStatus;
    }

    public void setMatchUnitSize(int matchUnitSize) {
        this.matchUnitSize = matchUnitSize;
    }

    public int getMatchUnitSize() {
        return matchUnitSize;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setWantMeetTime(long wantMeetTime) {
        this.wantMeetTime = wantMeetTime;
    }

    public long getWantMeetTime() {
        return wantMeetTime;
    }
}
