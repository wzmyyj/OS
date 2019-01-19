package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2019/01/19.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class Record {

    private float afterBalance;
    private float changeAmount;
    private long createDate;
    private int enableStatus;
    private float previousBalance;
    private String relatedId;
    private int relatedStatus;
    private String title;

    public void setAfterBalance(float afterBalance) {
        this.afterBalance = afterBalance;
    }

    public float getAfterBalance() {
        return afterBalance;
    }

    public void setChangeAmount(float changeAmount) {
        this.changeAmount = changeAmount;
    }

    public float getChangeAmount() {
        return changeAmount;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setEnableStatus(int enableStatus) {
        this.enableStatus = enableStatus;
    }

    public int getEnableStatus() {
        return enableStatus;
    }

    public void setPreviousBalance(float previousBalance) {
        this.previousBalance = previousBalance;
    }

    public float getPreviousBalance() {
        return previousBalance;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedStatus(int relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public int getRelatedStatus() {
        return relatedStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

