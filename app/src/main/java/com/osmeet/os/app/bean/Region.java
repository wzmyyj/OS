/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Region {

    private String cityLevelId;
    private long createDate;
    private String districtLevelId;
    private String id;
    private int level;
    private long modifyDate;
    private String name;
    private int status;

    public void setCityLevelId(String cityLevelId) {
        this.cityLevelId = cityLevelId;
    }

    public String getCityLevelId() {
        return cityLevelId;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setDistrictLevelId(String districtLevelId) {
        this.districtLevelId = districtLevelId;
    }

    public String getDistrictLevelId() {
        return districtLevelId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}