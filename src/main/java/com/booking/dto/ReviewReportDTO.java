package com.booking.dto;

import com.booking.domain.ReviewType;
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
