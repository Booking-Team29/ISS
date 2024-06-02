package com.booking.dto.Review;

import com.booking.domain.Review.Review;
import com.booking.domain.Review.ReviewReport;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllReviewReportsDTO {
    public List<ReviewReport> reports;
    public List<Review> reviews;

}
