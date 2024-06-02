package com.booking.dto.Report;

import com.booking.domain.Review.ReviewType;
import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Data
@Getter
@Setter
public class ReviewReportDTO {
    private Long ReportId = null;
    private LocalDate ReportDate;
    private String Description;
    private ReviewType Type;
}
