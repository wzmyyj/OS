/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Goods {

    private String id;
    private long createDate;
    private long modifyDate;
    private float discountPrice;
    private float originalPrice;
    private Store store;
    private String name;
    private String nameEn;
    private String introduce;
    private String introduceEn;
    private List<FileInfo> images;
    private long startTime;
    private long endTime;
    private int supplyLimitedAmount;
    private int buyLimitedAmount;
    private int soldAmount;
    private int supplyLimitedType;
    private long lastRefundTime;
    private int enabledState;
    private int exchangedAmount;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduceEn(String introduceEn) {
        this.introduceEn = introduceEn;
    }

    public String getIntroduceEn() {
        return introduceEn;
    }

    public void setImages(List<FileInfo> images) {
        this.images = images;
    }

    public List<FileInfo> getImages() {
        return images;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setSupplyLimitedAmount(int supplyLimitedAmount) {
        this.supplyLimitedAmount = supplyLimitedAmount;
    }

    public int getSupplyLimitedAmount() {
        return supplyLimitedAmount;
    }

    public void setBuyLimitedAmount(int buyLimitedAmount) {
        this.buyLimitedAmount = buyLimitedAmount;
    }

    public int getBuyLimitedAmount() {
        return buyLimitedAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSupplyLimitedType(int supplyLimitedType) {
        this.supplyLimitedType = supplyLimitedType;
    }

    public int getSupplyLimitedType() {
        return supplyLimitedType;
    }

    public void setLastRefundTime(long lastRefundTime) {
        this.lastRefundTime = lastRefundTime;
    }

    public long getLastRefundTime() {
        return lastRefundTime;
    }

    public void setEnabledState(int enabledState) {
        this.enabledState = enabledState;
    }

    public int getEnabledState() {
        return enabledState;
    }

    public void setExchangedAmount(int exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }

    public int getExchangedAmount() {
        return exchangedAmount;
    }


    public static class SimpleGoods implements Serializable {
        private String id;
        private float discountPrice;
        private float originalPrice;
        private String name;
        private String nameEn;
        private String imageUrl;

        public SimpleGoods(Goods goods) {
            this.id = goods.getId();
            this.discountPrice = goods.getDiscountPrice();
            this.originalPrice = goods.getOriginalPrice();
            this.name = goods.getName();
            this.nameEn = goods.getNameEn();
            if (goods.getImages() != null && goods.getImages().size() > 0)
                this.imageUrl = goods.getImages().get(0).getUrl();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public float getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(float discountPrice) {
            this.discountPrice = discountPrice;
        }

        public float getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(float originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameEn() {
            return nameEn;
        }

        public void setNameEn(String nameEn) {
            this.nameEn = nameEn;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}