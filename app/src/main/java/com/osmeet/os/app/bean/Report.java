package com.osmeet.os.app.bean;

/**
 * Created by yyj on 2018/12/04. email: 2209011667@qq.com
 */

public class Report {

    public static final int REPORT_USER = 1;
    public static final int REPORT_STORE = 2;
    private long createDate;
    private String id;
    private long modifyDate;
    private String reportContent;
    private String reportOne;
    private String reportOneType;
    private int reportType;
    private String reporter;
    private int status;

    public Report() {
    }

    public Report(int reportType, String reporter, String reportContent) {
        this.reportType = reportType;
        this.reporter = reporter;
        this.reportContent = reportContent;
    }

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

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getModifyDate() {
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

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public int getReportType() {
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
