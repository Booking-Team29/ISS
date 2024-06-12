package com.booking.service;

import com.booking.domain.Review.Review;
import com.booking.dto.Review.ReviewDTO;
import com.booking.repository.ReviewsRepository;
import com.booking.repository.UserRepository;
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

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

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
            dtos.add(Review.toDTO(review, userRepository));
        }
        return dtos;
    }

    public List<ReviewDTO> getAccommodationReviewsByAccommodationId(Long accommodationId) {
        List<ReviewDTO> dtos = new ArrayList<>();
        for (Review review : reviewsRepository.getAccommodationReviewsByAccommodationId(accommodationId)) {
            if (review.getAccommodationId().equals(accommodationId)) {
                dtos.add(Review.toDTO(review, userRepository));
            }
        }
        return dtos;
    }

    public ReviewDTO createUserReview(ReviewDTO dto) {
        Review review = Review.fromDTO(dto, userService);

        System.out.println("gaming: "+ review);
        System.out.println("gaming2:");
        System.out.println(dto.getUserId());


        return Review.toDTO(reviewsRepository.save(review), userRepository);
    }

    public ReviewDTO createAccommodationReview(ReviewDTO dto) {
        Review review = Review.fromDTO(dto, userService);

        return Review.toDTO(reviewsRepository.save(review), userRepository);
    }

    public void deleteReview(Long reviewId) {
        reviewsRepository.deleteById(reviewId);
    }

    public List<ReviewDTO> getUserReviewsById(Long userId) {
        System.out.println("hello");
        for (Review review : reviewsRepository.findAll()) {
            System.out.println(review);
        }
        List<ReviewDTO> dtos = new ArrayList<>();
        for (Review review : reviewsRepository.getUserReviewsById(userId)) {
            System.out.println(review);
            dtos.add(Review.toDTO(review, userRepository));
        }
        return dtos;
    }
}