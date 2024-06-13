package com.booking.repository;

import com.booking.domain.Review.Review;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import java.time.LocalDate;

@Repository
public interface ReviewsRepository extends GenericRepository<Review> {
    @Query(value = "select avg(r.rating) from Review r where r.accommodationId = :accommodationId", nativeQuery = true)
    public Optional<Double> ratingForAccommodation(@Param("accommodationId") Long accommodationId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Review r WHERE r.reviewId = :reviewId")
    public void markDeleted(Long reviewId);

    @Query("SELECT r FROM Review r WHERE r.reviewId = :reviewId")
    public Optional<Review> findById(Long reviewId);

    @Query("SELECT r FROM Review r WHERE r.accommodationId != null")
    public List<Review> getAllAccommodationReviews();

    @Query("SELECT r FROM Review r WHERE r.accommodationId = :accommodationId")
    public List<Review> getAccommodationReviewsByAccommodationId(Long accommodationId);

    @Query("SELECT r FROM Review r WHERE r.userId = :userId")
    public List<Review> getUserReviewsById(Long userId);
}
