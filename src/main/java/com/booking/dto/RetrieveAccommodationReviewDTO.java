package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RetrieveAccommodationReviewDTO extends ReviewDTO {
    private Long AccommodationId;

    protected RetrieveAccommodationReviewDTO() {}
    protected RetrieveAccommodationReviewDTO(Date reviewDate, String description, float rating, Long accommodationId) {
        super(reviewDate, description, rating);
        this.AccommodationId = accommodationId;
    }
}
