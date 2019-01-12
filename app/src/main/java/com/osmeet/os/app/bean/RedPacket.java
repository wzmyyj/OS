package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class RedPacket {


    private int amount;
    private int enableState;
    private Date getDate;
    private String id;
    private String storeId;
    private String userId;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setEnableState(int enableState) {
        this.enableState = enableState;
    }

    public int getEnableState() {
        return enableState;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }


}
