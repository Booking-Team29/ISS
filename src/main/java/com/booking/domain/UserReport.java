package com.booking.domain;

import java.time.LocalDate;

public class UserReport {

    private Long reportId;
    private LocalDate reportDate;
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

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
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
