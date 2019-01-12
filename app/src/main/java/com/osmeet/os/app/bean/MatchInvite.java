package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/02. email: 2209011667@qq.com
 */

public class MatchInvite {

    private String id;
    private int inviteMode;
    private MatchUnit invitedMatchUnit;
    private MatchUnit matchUnit;
    private int status;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInviteMode(int inviteMode) {
        this.inviteMode = inviteMode;
    }

    public int getInviteMode() {
        return inviteMode;
    }

    public void setInvitedMatchUnit(MatchUnit invitedMatchUnit) {
        this.invitedMatchUnit = invitedMatchUnit;
    }

    public MatchUnit getInvitedMatchUnit() {
        return invitedMatchUnit;
    }

    public void setMatchUnit(MatchUnit matchUnit) {
        this.matchUnit = matchUnit;
    }

    public MatchUnit getMatchUnit() {
        return matchUnit;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
