package com.booking.domain;

import java.time.LocalDate;
import java.util.Date;

public class AccommodaitonReview extends Review{
    private long AccommodationId;

    public AccommodaitonReview(Long reviewId, LocalDate reviewDate, String description, Double rating, long accommodationId) {
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
