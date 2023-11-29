package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class ReviewDTO {

    protected Long reviewId;
    protected Date reviewDate;
    protected String description;
    protected float rating;

    protected ReviewDTO() {}

    protected ReviewDTO(Date reviewDate, String description, float rating) {
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }

    protected ReviewDTO(Long id, Date reviewDate, String description, float rating) {
        this.reviewId = id;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}

