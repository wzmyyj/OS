package com.osmeet.os.app.bean;

import java.util.Date;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Report {

    private Date createDate;
    private String id;
    private Date modifyDate;
    private String reportContent;
    private String reportOne;
    private String reportOneType;
    private String reportType;
    private String reporter;
    private int status;

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

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportOne(String reportOne) {
        this.reportOne = reportOne;
    }

    public String getReportOne() {
        return reportOne;
    }

    public void setReportOneType(String reportOneType) {
        this.reportOneType = reportOneType;
    }

    public String getReportOneType() {
        return reportOneType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporter() {
        return reporter;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
