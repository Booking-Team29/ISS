package com.booking.service;

import com.booking.domain.Review.Review;

import java.util.Optional;

public interface ReviewService {
    public Double accommodationRating(Long accommodationId);
    public Optional<Review> findById(Long id);
    public void deleteById(Long reviewId);
}
