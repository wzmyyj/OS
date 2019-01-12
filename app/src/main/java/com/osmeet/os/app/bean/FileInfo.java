/**
 * Copyright 2018 bejson.com
 */
package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 * a file: 文件信息实体类。
 */

public class FileInfo {

    private String contentType;
    private long createDate;
    private int examineStatus;
    private String id;
    private long modifyDate;
    private String name;
    private String path;
    private String url;

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setExamineStatus(int examineStatus) {
        this.examineStatus = examineStatus;
    }

    public int getExamineStatus() {
        return examineStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}