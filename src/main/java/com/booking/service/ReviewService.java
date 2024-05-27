package com.booking.service;

import com.booking.domain.Review.Review;
import com.booking.dto.Review.CreateUserReviewDTO;

import java.util.Optional;

public interface ReviewService {
    public Optional<Double> accommodationRating(Long accommodationId);
    public Optional<Review> findById(Long id);
    public void deleteById(Long reviewId);
    public void createUserReview(CreateUserReviewDTO review);
}
