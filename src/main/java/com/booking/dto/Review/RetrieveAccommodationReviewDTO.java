package com.booking.dto.Review;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RetrieveAccommodationReviewDTO extends ReviewDTO {
    private Long AccommodationId;

    protected RetrieveAccommodationReviewDTO() {}
    protected RetrieveAccommodationReviewDTO(LocalDate reviewDate, String description, float rating, Long accommodationId) {
        super(reviewDate, description, rating);
        this.AccommodationId = accommodationId;
    }
}
