package com.booking.domain.Review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
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

    protected Review(Long reviewId, LocalDate reviewDate, String description, Double rating) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}
