package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Invite {

    private String cancelReason;
    private Date createDate;
    private boolean finishedOne;
    private boolean finishedTwo;
    private String id;
    private int inviteMode;
    private User invitedUser;
    private int inviterDestinationState;
    private Date meetTime;
    private String state;
    private int status;
    private Store store;
    private User user;

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setFinishedOne(boolean finishedOne) {
        this.finishedOne = finishedOne;
    }

    public boolean getFinishedOne() {
        return finishedOne;
    }

    public void setFinishedTwo(boolean finishedTwo) {
        this.finishedTwo = finishedTwo;
    }

    public boolean getFinishedTwo() {
        return finishedTwo;
    }

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

    public void setInvitedUser(User invitedUser) {
        this.invitedUser = invitedUser;
    }

    public User getInvitedUser() {
        return invitedUser;
    }

    public void setInviterDestinationState(int inviterDestinationState) {
        this.inviterDestinationState = inviterDestinationState;
    }

    public int getInviterDestinationState() {
        return inviterDestinationState;
    }

    public void setMeetTime(Date meetTime) {
        this.meetTime = meetTime;
    }

    public Date getMeetTime() {
        return meetTime;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
