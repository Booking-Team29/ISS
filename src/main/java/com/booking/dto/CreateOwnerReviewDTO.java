package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateOwnerReviewDTO extends ReviewDTO {
    private Long OwnerId;

    public CreateOwnerReviewDTO() {}

    public CreateOwnerReviewDTO(Date reviewDate, String description, float rating, long ownerId) {
        super(reviewDate, description, rating);
        OwnerId = ownerId;
    }
}
