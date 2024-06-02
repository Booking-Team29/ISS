package com.booking.repository;

import com.booking.domain.Review.ReviewReport;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewReportRepository extends GenericRepository<ReviewReport> {
    public ReviewReport save(ReviewReport report);
    public void deleteById(Long reportId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ReviewReport rr WHERE rr.ReviewId = :reviewId")
    public void deleteReferencingReviewId(Long reviewId);

    @Query("SELECT r FROM ReviewReport r")
    public List<ReviewReport> getAllReports();
}
