package com.booking.service;

import com.booking.domain.Review.ReviewReport;

import java.util.List;

public interface ReviewReportService {
    public ReviewReport save(ReviewReport report);
    public void deleteById(Long reportId);
    public void deleteReferencingReviewId(Long reviewId);
    public List<ReviewReport> getAllReports();
}
