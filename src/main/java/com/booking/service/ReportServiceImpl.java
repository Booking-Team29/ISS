package com.booking.service;

import com.booking.domain.Report.UserReport;
import com.booking.dto.Report.UserReportDTO;
import com.booking.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public void createUserReport(UserReportDTO userReportDTO) {
        UserReport userReport = new UserReport();

        userReport.setReporterId(userReport.getReporterId());
        userReport.setReportDate(userReport.getReportDate());
        userReport.setReportID(userReport.getReportID());
        userReport.setDescription(userReport.getDescription());
        userReport.setReporteeId(userReport.getReporteeId());

        reportRepository.save(userReport);
    }
}
