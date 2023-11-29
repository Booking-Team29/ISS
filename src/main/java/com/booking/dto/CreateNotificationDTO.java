package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateNotificationDTO {
    private String content;
    private Date creationTime;
    private boolean read;

    public CreateNotificationDTO() {}

    public CreateNotificationDTO(String content, Date creationTime, boolean read) {}
}
