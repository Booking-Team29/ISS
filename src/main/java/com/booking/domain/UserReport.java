package com.booking.domain;

import java.util.Date;

public class UserReport {

    private Long reportId;
    private Date reportDate;
    private String description;
    private Long reporterId;
    private Long reporteeId;


    public UserReport() {

    }

    public long getReportID() {
        return reportId;
    }

    public void setReportID(long reportID) {
        this.reportId = reportID;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getReporterId() {
        return reporterId;
    }

    public void setReporterId(long reporterId) {
        this.reporterId = reporterId;
    }

    public long getReporteeId() {
        return reporteeId;
    }

    public void setReporteeId(long reporteeId) {
        this.reporteeId = reporteeId;
    }
}
