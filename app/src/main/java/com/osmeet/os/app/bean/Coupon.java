package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Coupon {

    private int couponAmount;
    private int couponEnableAmount;
    private int couponEnableState;
    private Date createDate;
    private String id;
    private Date modifyDate;
    private int redPacketEnableState;
    private int redPacketMaxAmount;
    private int redPacketMinAmount;
    private String storeId;

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponEnableAmount(int couponEnableAmount) {
        this.couponEnableAmount = couponEnableAmount;
    }

    public int getCouponEnableAmount() {
        return couponEnableAmount;
    }

    public void setCouponEnableState(int couponEnableState) {
        this.couponEnableState = couponEnableState;
    }

    public int getCouponEnableState() {
        return couponEnableState;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setRedPacketEnableState(int redPacketEnableState) {
        this.redPacketEnableState = redPacketEnableState;
    }

    public int getRedPacketEnableState() {
        return redPacketEnableState;
    }

    public void setRedPacketMaxAmount(int redPacketMaxAmount) {
        this.redPacketMaxAmount = redPacketMaxAmount;
    }

    public int getRedPacketMaxAmount() {
        return redPacketMaxAmount;
    }

    public void setRedPacketMinAmount(int redPacketMinAmount) {
        this.redPacketMinAmount = redPacketMinAmount;
    }

    public int getRedPacketMinAmount() {
        return redPacketMinAmount;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreId() {
        return storeId;
    }

}
