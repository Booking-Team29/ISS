package com.booking.domain.Review;

import com.booking.domain.User.Account;
import com.booking.dto.Review.ReviewDTO;
import com.booking.repository.UserRepository;
import com.booking.service.UserService;
import com.booking.service.UserServiceImpl;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    protected Long reviewId;

    @Column(name = "reviewerid")
    protected Long reviewerId;

    @Column(name = "reviewdate")
    protected LocalDate reviewDate;

    @Column(name = "description")
    protected String description;

    @Column(name = "rating")
    protected Double rating;

    @Column(name = "approved")
    protected Boolean approved;

    @Column(name = "reservationid", nullable = true)
    protected Long reservationId;

    @Column(name = "userid", nullable = true)
    protected Long userId;

    @Column(name = "accommodationid", nullable = true)
    protected Long accommodationId;

    public static Review fromDTO(ReviewDTO dto, UserService userService) {
        if (dto == null) {
            return null;
        }
        Review review = new Review();
        review.setReviewDate(dto.getReviewDate());
        review.setDescription(dto.getDescription());
        review.setRating(dto.getRating());
        review.setApproved(dto.getApproved());
        review.setReservationId(dto.getReservationId());
        review.setUserId(dto.getUserId());

        Optional<Account> acc = userService.findByEmail(dto.getReviewerEmail());
        if (acc.isEmpty()) {
            throw new IllegalArgumentException("User with email (" + dto.getReviewerEmail() + ") not found");
        }

        Long reviewerId = acc.get().getUserId();
        review.setReviewerId(reviewerId);

        review.setAccommodationId(dto.getAccommodationId());

        assert review.reviewerId != null;
        return review;
    }

    public static ReviewDTO toDTO(Review review, UserRepository userRepo) {
        Optional<Account> acc = userRepo.findById(review.getReviewerId());
        if (acc.isEmpty()) {
            throw new IllegalArgumentException("User with id (" + review.getReviewerId() + ") not found");
        }
        String email = acc.get().getEmailAddress();

        return new ReviewDTO(
                review.reviewId,
                email,
                review.reviewDate,
                review.description,
                review.rating,
                review.approved,
                review.reservationId,
                review.userId,
                review.accommodationId
        );
    }
}
