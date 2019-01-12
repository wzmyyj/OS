package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class AliPay {

    private String alipay_buyer_id;
    private int alipay_state;
    private String alipay_trade_no;
    private int amount;
    private int amountPaid;
    private Date createDate;
    private int enabledState;
    private String goodsId;
    private String id;
    private Date modifyDate;
    private int purchaseAmount;
    private String qrcodeData;
    private String serialNumber;
    private String state;
    private String storeId;
    private String userId;

    public void setAlipay_buyer_id(String alipay_buyer_id) {
        this.alipay_buyer_id = alipay_buyer_id;
    }

    public String getAlipay_buyer_id() {
        return alipay_buyer_id;
    }

    public void setAlipay_state(int alipay_state) {
        this.alipay_state = alipay_state;
    }

    public int getAlipay_state() {
        return alipay_state;
    }

    public void setAlipay_trade_no(String alipay_trade_no) {
        this.alipay_trade_no = alipay_trade_no;
    }

    public String getAlipay_trade_no() {
        return alipay_trade_no;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setEnabledState(int enabledState) {
        this.enabledState = enabledState;
    }

    public int getEnabledState() {
        return enabledState;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsId() {
        return goodsId;
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

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setQrcodeData(String qrcodeData) {
        this.qrcodeData = qrcodeData;
    }

    public String getQrcodeData() {
        return qrcodeData;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
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
