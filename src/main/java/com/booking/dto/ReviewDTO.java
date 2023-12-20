package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public abstract class ReviewDTO {

    protected Long reviewId;
    protected LocalDate reviewDate;
    protected String description;
    protected float rating;

    protected ReviewDTO() {}

    protected ReviewDTO(LocalDate reviewDate, String description, float rating) {
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }

    protected ReviewDTO(Long id, LocalDate reviewDate, String description, float rating) {
        this.reviewId = id;
        this.reviewDate = reviewDate;
        this.description = description;
        this.rating = rating;
    }
}

