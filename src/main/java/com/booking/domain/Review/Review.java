package com.booking.domain.Review;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long reviewId;
    protected LocalDate reviewDate;
    protected String description;
    protected Double rating;

    protected Review(Long reviewId, LocalDate reviewDate, String description, Double rating) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}
