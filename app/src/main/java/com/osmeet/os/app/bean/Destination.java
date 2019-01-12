package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/05. email: 2209011667@qq.com
 */

public class Destination {

    private String id;
    private Invite invite;
    private int inviteMode;
    private int matchCount;
    private int status;
    private Store store;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInviteMode(int inviteMode) {
        this.inviteMode = inviteMode;
    }

    public int getInviteMode() {
        return inviteMode;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

}
