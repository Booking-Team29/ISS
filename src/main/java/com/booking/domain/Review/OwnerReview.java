package com.booking.domain.Review;

import java.time.LocalDate;

public class OwnerReview extends Review {
    private Long OwnerId;

    public OwnerReview(Long reviewId, LocalDate reviewDate, String description, Double rating, Long ownerId) {
        super(reviewId, reviewDate, description, rating);
        OwnerId = ownerId;
    }

    public long getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(long ownerId) {
        OwnerId = ownerId;
    }
}
