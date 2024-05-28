package com.booking.repository;

import com.booking.domain.Report.UserReport;
import com.booking.dto.Report.UserReportDTO;

public interface ReportRepository extends GenericRepository<UserReport> {
    // this method is used to create a user report
    public UserReport save(UserReportDTO userReportDTO);
}