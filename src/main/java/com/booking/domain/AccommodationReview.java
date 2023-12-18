package com.booking.domain;

import java.util.Date;

public class AccommodationReview extends Review{
    private Long AccommodationId;

    public AccommodationReview(Long reviewId, Date reviewDate, String description, float rating, long accommodationId) {
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
