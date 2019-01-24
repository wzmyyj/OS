package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/05. email: 2209011667@qq.com
 */

public class Friend {
    //0申请,1取消,2同意 ,3 拒绝,4删除,10申请者拉黑,11接受人拉黑,12好友双方拉黑,13 A陌生人拉黑,14 B陌生人拉黑,15 陌生人双方拉黑
    public static final int APPLY = 0;
    public static final int CANCEL = 1;
    public static final int AGREE = 2;
    public static final int REFUSE = 3;
    public static final int DELETE = 4;
    public static final int BLOCK_BY_APPLY = 10;
    public static final int BLOCK_BY_ACCEPT = 11;
    public static final int BLOCK_BY_FRIEND = 12;
    public static final int BLOCK_BY_STRANGER_A = 13;
    public static final int BLOCK_BY_STRANGER_B = 14;
    public static final int BLOCK_BY_STRANGER = 15;


    private long createDate;
    private String message;
    private long modifyDate;
    private int readStatus;
    private int side;
    private int status;
    private User user;

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
