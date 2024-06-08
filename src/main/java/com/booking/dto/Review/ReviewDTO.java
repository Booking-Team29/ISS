package com.booking.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewId;

    private String reviewerEmail;

    private LocalDate reviewDate;
    private String description;
    private Double rating;
    private Boolean approved;
    private Long reservationId;
    private Long userId;
    private Long accommodationId;
}