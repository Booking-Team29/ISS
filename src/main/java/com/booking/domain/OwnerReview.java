package com.booking.domain;

import java.util.Date;

public class OwnerReview extends Review {
    private Long OwnerId;

    public OwnerReview(int reviewId, Date reviewDate, String description, float rating, Long ownerId) {
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
