package com.booking.dto.Review;

import lombok.*;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportReviewDTO {
    private Long reviewId;
    private String description;
}
