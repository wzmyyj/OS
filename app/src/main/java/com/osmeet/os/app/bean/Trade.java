package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Trade {

    public static final String WAIT_PAY = "WP";
    public static final String PAY = "P";

    private String alipay_buyer_id;
    private int alipay_state;
    private String alipay_trade_no;
    private float amount;
    private float amountPaid;
    private long createDate;
    private int enabledState;
    private Goods goods;
    private String id;
    private long lastExchangeDate;
    private long modifyDate;
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

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setEnabledState(int enabledState) {
        this.enabledState = enabledState;
    }

    public int getEnabledState() {
        return enabledState;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLastExchangeDate(long lastExchangeDate) {
        this.lastExchangeDate = lastExchangeDate;
    }

    public long getLastExchangeDate() {
        return lastExchangeDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
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

    public String getStateDesc() {
        return "HA HA HA";
    }

}
