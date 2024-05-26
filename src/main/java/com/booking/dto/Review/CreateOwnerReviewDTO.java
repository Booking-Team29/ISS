package com.booking.dto.Review;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateOwnerReviewDTO extends ReviewDTO {
    private Long OwnerId;

    public CreateOwnerReviewDTO() {}

    public CreateOwnerReviewDTO(LocalDate reviewDate, String description, float rating, long ownerId) {
        super(reviewDate, description, rating);
        OwnerId = ownerId;
    }
}
