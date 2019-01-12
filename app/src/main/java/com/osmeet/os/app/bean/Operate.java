package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Operate {

    private String id;
    private Invite inviteId;
    private String state;
    private Date time;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInviteId(Invite inviteId) {
        this.inviteId = inviteId;
    }

    public Invite getInviteId() {
        return inviteId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

}
