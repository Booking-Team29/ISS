package com.booking.domain.Review;

import java.time.LocalDate;

public class AccommodationReview extends Review {
    private Long AccommodationId;

    public AccommodationReview(Long reviewId, LocalDate reviewDate, String description, Double rating, long accommodationId) {
        super(reviewId, reviewDate, description, rating);
        AccommodationId = accommodationId;
    }

    public long getAccommodationId() {
        return AccommodationId;
    }

    public void setAccommodationId(long accommodationId) {
        AccommodationId = accommodationId;
    }
}
