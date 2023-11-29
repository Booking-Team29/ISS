package com.booking.dto;

import com.booking.domain.ReviewType;
import lombok.*;

import java.util.Date;

@ToString
@EqualsAndHashCode
@Data
@Getter
@Setter
public class ReviewReportDTO {
    private Long ReportId = null;
    private Date ReportDate;
    private String Description;
    private ReviewType Type;
}
