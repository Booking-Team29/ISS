package com.booking.dto.Review;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserReviewDTO extends ReviewDTO {
    private Long UserId;

    public CreateUserReviewDTO() {}

    public CreateUserReviewDTO(LocalDate reviewDate, String description, float rating, long UserId) {
        super(reviewDate, description, rating);
        this.UserId = UserId;
    }
}
