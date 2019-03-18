/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Store {

    private String addressStr;
    private String addressStrEn;
    private User boss;
    private Category category;
    private FileInfo coverImage;
    private long createDate;
    private long endTime;
    private String id;
    private List<FileInfo> images;
    private String introduce;
    private String introduceEn;
    private int lat;
    private int lng;
    private FileInfo logoImage;
    private String logoImageId;
    private String matchRelatedId;
    private int matchState;
    private int matchUnitCount;
    private String name;
    private String nameEn;
    private String openDay;
    private String phone;
    private String poiId;
    private int sequence;
    private long startTime;
    private int validState;

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStrEn(String addressStrEn) {
        this.addressStrEn = addressStrEn;
    }

    public String getAddressStrEn() {
        return addressStrEn;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public User getBoss() {
        return boss;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCoverImage(FileInfo coverImage) {
        this.coverImage = coverImage;
    }

    public FileInfo getCoverImage() {
        return coverImage;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setImages(List<FileInfo> images) {
        this.images = images;
    }

    public List<FileInfo> getImages() {
        return images;
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

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLat() {
        return lat;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getLng() {
        return lng;
    }

    public void setLogoImage(FileInfo logoImage) {
        this.logoImage = logoImage;
    }

    public FileInfo getLogoImage() {
        return logoImage;
    }

    public void setLogoImageId(String logoImageId) {
        this.logoImageId = logoImageId;
    }

    public String getLogoImageId() {
        return logoImageId;
    }

    public void setMatchRelatedId(String matchRelatedId) {
        this.matchRelatedId = matchRelatedId;
    }

    public String getMatchRelatedId() {
        return matchRelatedId;
    }

    public void setMatchState(int matchState) {
        this.matchState = matchState;
    }

    public int getMatchState() {
        return matchState;
    }

    public void setMatchUnitCount(int matchUnitCount) {
        this.matchUnitCount = matchUnitCount;
    }

    public int getMatchUnitCount() {
        return matchUnitCount;
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

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setValidState(int validState) {
        this.validState = validState;
    }

    public int getValidState() {
        return validState;
    }

}