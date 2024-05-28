package com.booking.domain.Report;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class UserReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
