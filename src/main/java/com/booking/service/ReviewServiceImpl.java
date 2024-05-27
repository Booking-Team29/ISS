package com.booking.service;

import com.booking.domain.Review.Review;
import com.booking.dto.Review.CreateUserReviewDTO;
import com.booking.repository.ReviewsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    public ReviewsRepository reviewsRepository;

    @Override
    public Optional<Double> accommodationRating(Long accommodationId) { return reviewsRepository.ratingForAccommodation(accommodationId); }

    public Optional<Review> findById(Long id) {
        return reviewsRepository.findById(id);
    }

    public void deleteById(Long reviewId) {
        reviewsRepository.deleteById(reviewId);

    // this method creates a review for a user
    public void createUserReview(CreateUserReviewDTO review) {
        reviewsRepository.createUserReview(review.getReviewDate(), review.getDescription(), review.getRating(), review.getUserId());
    }
}
