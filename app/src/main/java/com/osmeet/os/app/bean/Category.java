/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */

public class Category {


    private long createDate;
    private String id;
    private FileInfo logo;
    private long modifyDate;
    private String name;
    private String nameEn;
    private int sequence;
    private int status;

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLogo(FileInfo logo) {
        this.logo = logo;
    }

    public FileInfo getLogo() {
        return logo;
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

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}