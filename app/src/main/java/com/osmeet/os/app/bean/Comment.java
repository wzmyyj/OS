package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Comment {

    private int commentScore;
    private int creditScore;
    private int inviteCount;
    private int successInviteCount;
    private String userId;

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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
