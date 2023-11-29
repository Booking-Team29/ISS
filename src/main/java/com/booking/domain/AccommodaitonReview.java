package com.booking.domain;

import java.util.Date;

public class AccommodaitonReview extends Review{
    private Long AccommodationId;

    public AccommodaitonReview(int reviewId, Date reviewDate, String description, float rating, long accommodationId) {
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
