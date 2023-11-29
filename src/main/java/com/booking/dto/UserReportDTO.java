package com.booking.dto;

import lombok.*;

import java.util.Date;


@EqualsAndHashCode
@ToString
@Data
@Getter
@Setter
public class UserReportDTO {
    private Long reportId = null;
    private Date reportDate;
    private String description;
    private Long reporterId;
    private Long reporteeId;
}