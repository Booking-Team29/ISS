package com.booking.domain;

import java.time.LocalDate;

public abstract class Review {
    protected Long reviewId;
    protected LocalDate reviewDate;
    protected String description;
    protected float rating;

    protected Review(Long reviewId, LocalDate reviewDate, String description, float rating) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}
