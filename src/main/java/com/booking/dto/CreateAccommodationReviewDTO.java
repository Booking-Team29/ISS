package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateAccommodationReviewDTO extends ReviewDTO {
    private Long AccommodationId;

    protected CreateAccommodationReviewDTO() {}
    protected CreateAccommodationReviewDTO(Date reviewDate, String description, float rating, Long accommodationId) {
        super(reviewDate, description, rating);
        this.AccommodationId = accommodationId;
    }
}
