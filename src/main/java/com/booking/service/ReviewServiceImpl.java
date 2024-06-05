package com.booking.service;

import com.booking.domain.Review.Review;
import com.booking.dto.Review.ReviewDTO;
import com.booking.repository.ReviewsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    }

    public List<ReviewDTO> getAllAccommodationReviews() {
        List<ReviewDTO> dtos = new ArrayList<>();
        for (Review review : reviewsRepository.getAllAccommodationReviews()) {
            dtos.add(review.toDTO());
        }
        return dtos;
    }

    public void createUserReview(ReviewDTO dto) {
        Review review = Review.fromDTO(dto);
        reviewsRepository.save(review);
    }

    public void createAccommodationReview(ReviewDTO dto) {
        Review newReview = Review.fromDTO(dto);
        reviewsRepository.save(newReview);
    }

    public void deleteReview(Long reviewId) {
        reviewsRepository.deleteById(reviewId);
    }
}
