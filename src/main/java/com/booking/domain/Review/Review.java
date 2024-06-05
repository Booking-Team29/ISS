package com.booking.domain.Review;

import com.booking.dto.Review.ReviewDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    public static Review fromDTO(ReviewDTO dto) {
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
        review.setAccommodationId(dto.getAccommodationId());
        return review;
    }

    public ReviewDTO toDTO() {
        return new ReviewDTO(
                this.reviewDate,
                this.description,
                this.rating,
                this.approved,
                this.reservationId,
                this.userId,
                this.accommodationId
        );
    }
}
