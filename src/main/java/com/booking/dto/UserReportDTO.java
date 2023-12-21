package com.booking.dto;

import lombok.*;

import java.time.LocalDate;


@EqualsAndHashCode
@ToString
@Data
@Getter
@Setter
public class UserReportDTO {
    private Long reportId = null;
    private LocalDate reportDate;
    private String description;
    private Long reporterId;
    private Long reporteeId;
}
