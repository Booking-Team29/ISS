package com.booking.domain;

import java.util.Date;

public abstract class Review {
    protected int reviewId;
    protected Date reviewDate;
    protected String description;
    protected float rating;

    protected Review(int reviewId, Date reviewDate, String description, float rating) {
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}