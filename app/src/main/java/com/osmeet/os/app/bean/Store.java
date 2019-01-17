/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

import java.util.List;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Store {

    private User boss;
    private String addressStr;
    private String bossPhone;
    private Category category;
    private long createDate;
    private long endTime;
    private int endTimeStamp;
    private String id;
    private List<FileInfo> images;
    private String introduce;
    private String introduceEn;
    private double lat;
    private double lng;
    private FileInfo logoImage;
    private FileInfo coverImage;
    private int matchUnitCount;
    private String name;
    private String nameEn;
    private String openDay;
    private String phone;
    private Region region;
    private int sequence;
    private long startTime;
    private int startTimeStamp;
    private int validState;

    private List<String> avatarIds;
    private List<String> avatarUrls;

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public List<String> getAvatarIds() {
        return avatarIds;
    }

    public void setAvatarIds(List<String> avatarIds) {
        this.avatarIds = avatarIds;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setBossPhone(String bossPhone) {
        this.bossPhone = bossPhone;
    }

    public String getBossPhone() {
        return bossPhone;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
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

    public void setEndTimeStamp(int endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public int getEndTimeStamp() {
        return endTimeStamp;
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

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }

    public void setLogoImage(FileInfo logoImage) {
        this.logoImage = logoImage;
    }

    public FileInfo getLogoImage() {
        return logoImage;
    }

    public FileInfo getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(FileInfo coverImage) {
        this.coverImage = coverImage;
    }

    public int getMatchUnitCount() {
        return matchUnitCount;
    }

    public void setMatchUnitCount(int matchUnitCount) {
        this.matchUnitCount = matchUnitCount;
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

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
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

    public void setStartTimeStamp(int startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public int getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setValidState(int validState) {
        this.validState = validState;
    }

    public int getValidState() {
        return validState;
    }

    public List<String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(List<String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }
}