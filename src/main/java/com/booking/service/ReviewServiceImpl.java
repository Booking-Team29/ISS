package com.booking.service;

import com.booking.domain.Review.Review;
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
    public Double accommodationRating(Long accommodationId) { return reviewsRepository.ratingForAccommodation(accommodationId); }

    public Optional<Review> findById(Long id) {
        return reviewsRepository.findById(id);
    }

    public void deleteById(Long reviewId) {
        reviewsRepository.deleteById(reviewId);
    }
}
