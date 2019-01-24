package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/24.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MatchInvite2 {

    // for friends.


    private String id;
    private int inviteMode;
    private MatchUnit matchUnit;
    private int status;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInviteMode() {
        return inviteMode;
    }

    public void setInviteMode(int inviteMode) {
        this.inviteMode = inviteMode;
    }

    public MatchUnit getMatchUnit() {
        return matchUnit;
    }

    public void setMatchUnit(MatchUnit matchUnit) {
        this.matchUnit = matchUnit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
