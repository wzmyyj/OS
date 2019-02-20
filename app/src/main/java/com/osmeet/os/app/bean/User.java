/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import top.wzmyyj.wzm_sdk.utils.TimeUtil;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class User {

    private FileInfo avatar;
    private String birthday;
    private String boundStore;
    private String company;
    private Credit credit;
    private int creditScore;
    private int examineStatus;
    private String fieldOfWork;
    private int friendRelationship;
    private String id;
    private List<FileInfo> images;
    private List<Store> inStore;
    private int inviteRelationship;
    private String inviteRelationshipInviteId;
    private String job;
    private String language;
    private double lat;
    private double lng;
    private String phone;
    private String pubbingId;
    private int relationship;
    private String school;
    private int sex;
    private String signature;
    private int status;
    private String username;
    private WechatInfo wechatInfo;
    private String zoneCode;

    public void setAvatar(FileInfo avatar) {
        this.avatar = avatar;
    }

    public FileInfo getAvatar() {
        return avatar;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBoundStore(String boundStore) {
        this.boundStore = boundStore;
    }

    public String getBoundStore() {
        return boundStore;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setExamineStatus(int examineStatus) {
        this.examineStatus = examineStatus;
    }

    public int getExamineStatus() {
        return examineStatus;
    }

    public void setFieldOfWork(String fieldOfWork) {
        this.fieldOfWork = fieldOfWork;
    }

    public String getFieldOfWork() {
        return fieldOfWork;
    }

    public void setFriendRelationship(int friendRelationship) {
        this.friendRelationship = friendRelationship;
    }

    public int getFriendRelationship() {
        return friendRelationship;
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

    public void setInStore(List<Store> inStore) {
        this.inStore = inStore;
    }

    public List<Store> getInStore() {
        return inStore;
    }

    public void setInviteRelationship(int inviteRelationship) {
        this.inviteRelationship = inviteRelationship;
    }

    public int getInviteRelationship() {
        return inviteRelationship;
    }

    public void setInviteRelationshipInviteId(String inviteRelationshipInviteId) {
        this.inviteRelationshipInviteId = inviteRelationshipInviteId;
    }

    public String getInviteRelationshipInviteId() {
        return inviteRelationshipInviteId;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPubbingId(String pubbingId) {
        this.pubbingId = pubbingId;
    }

    public String getPubbingId() {
        return pubbingId;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setWechatInfo(WechatInfo wechatInfo) {
        this.wechatInfo = wechatInfo;
    }

    public WechatInfo getWechatInfo() {
        return wechatInfo;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public int getAge() {
        if (getBirthday() == null) return 0;
        long birth = TimeUtil.str2long(getBirthday(), "yyyyMMdd");
        int b = TimeUtil.getYear(new Date(birth));
        int a = TimeUtil.getYear();
        if (a > b) {
            return a - b;
        } else {
            return 0;
        }
    }


    public String getPhone2() {
        if(phone!=null&&phone.length()==11){
            return phone.substring(0,3)+"****"+phone.substring(7,11);
        }
            return phone;
    }

    public String getBirthdayFormat(String format) {
        if (birthday == null) return null;
        long birth = TimeUtil.str2long(getBirthday(), "yyyyMMdd");
        return TimeUtil.long2str(birth, format);
    }

    // 测试例子。
    public static User newTestUser() {
        User user = new User();
        user.setSex(2);
        user.setUsername("Ashe");
        user.setSignature("Good good study, day day up!");
        user.setSchool("SSR");
        user.setCompany("ZWD");
        user.setJob("Android Coder");
        user.setBirthday("19970101");
        List<FileInfo> images = new ArrayList<>();
        FileInfo image = new FileInfo();
        image.setUrl("https://upload-images.jianshu" +
                ".io/upload_images/3262738-0a5b" +
                "030907019fd8.jpg?imageMogr2/a" +
                "uto-orient/strip%7CimageView2/2/w/1240");
        user.setAvatar(image);
        user.setCreditScore(90);
        for (int i = 1; i < 6; i++) {
            FileInfo img = new FileInfo();
            img.setUrl("https://upload-images.jianshu.i" +
                    "o/upload_images/326273" +
                    "8-ead0b680c718d0f0.jpg?image" +
                    "Mogr2/auto-orient/strip%7Cim" +
                    "ageView2/2/w/1240");
            images.add(img);
        }
        user.setImages(images);
        return user;
    }
}