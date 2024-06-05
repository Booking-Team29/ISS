package com.booking.service;

import com.booking.domain.Review.Review;
import com.booking.dto.Review.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Optional<Double> accommodationRating(Long accommodationId);
    public Optional<Review> findById(Long id);
    public void deleteById(Long reviewId);
    public void createUserReview(ReviewDTO review);

    public List<ReviewDTO> getAllAccommodationReviews();
    public void createAccommodationReview(ReviewDTO review);

    public void deleteReview(Long reviewId);
}
