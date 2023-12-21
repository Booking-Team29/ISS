package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RetrieveOwnerReviewDTO extends ReviewDTO {
    private long OwnerId;

    public RetrieveOwnerReviewDTO() {}

    public RetrieveOwnerReviewDTO(Long id, LocalDate reviewDate, String description, float rating, long ownerId) {
        super(id, reviewDate, description, rating);
        OwnerId = ownerId;
    }
}
