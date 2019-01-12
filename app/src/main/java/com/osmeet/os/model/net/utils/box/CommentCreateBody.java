package com.osmeet.os.model.net.utils.box;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class CommentCreateBody {

    private String content;
    private String inviteId;
    private int storeScore;
    private int userScore;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setStoreScore(int storeScore) {
        this.storeScore = storeScore;
    }

    public int getStoreScore() {
        return storeScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getUserScore() {
        return userScore;
    }

}