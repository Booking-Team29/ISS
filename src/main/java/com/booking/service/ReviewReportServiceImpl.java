package com.booking.service;

import com.booking.domain.Review.ReviewReport;
import com.booking.repository.ReviewReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewReportServiceImpl implements  ReviewReportService {
    @Autowired
    private ReviewReportRepository reviewReportRepository;

    public ReviewReport save(ReviewReport report) {
        return reviewReportRepository.save(report);
    }
    public void deleteById(Long reportId) {
        reviewReportRepository.deleteById(reportId);
    }
    public void deleteReferencingReviewId(Long reviewId) {
        reviewReportRepository.deleteReferencingReviewId(reviewId);
    }

    public List<ReviewReport> getAllReports() {
        return reviewReportRepository.getAllReports();
    }
}
