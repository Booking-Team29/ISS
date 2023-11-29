package com.booking.domain;

import java.util.Date;

public abstract class Review {
    protected Long reviewId;
    protected Date reviewDate;
    protected String description;
    protected float rating;

    protected Review(Long reviewId, Date reviewDate, String description, float rating) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}