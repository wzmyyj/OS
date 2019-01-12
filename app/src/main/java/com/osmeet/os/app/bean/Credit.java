/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Credit {

    private int commentScore;
    private int creditScore;
    private String id;
    private int inviteCount;
    private int successInviteCount;

    public void setCommentScore(int commentScore) {
        this.commentScore = commentScore;
    }

    public int getCommentScore() {
        return commentScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInviteCount(int inviteCount) {
        this.inviteCount = inviteCount;
    }

    public int getInviteCount() {
        return inviteCount;
    }

    public void setSuccessInviteCount(int successInviteCount) {
        this.successInviteCount = successInviteCount;
    }

    public int getSuccessInviteCount() {
        return successInviteCount;
    }

}