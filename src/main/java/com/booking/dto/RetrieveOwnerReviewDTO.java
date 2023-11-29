package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RetrieveOwnerReviewDTO extends ReviewDTO {
    private long OwnerId;

    public RetrieveOwnerReviewDTO() {}

    public RetrieveOwnerReviewDTO(Long id, Date reviewDate, String description, float rating, long ownerId) {
        super(id, reviewDate, description, rating);
        OwnerId = ownerId;
    }
}
