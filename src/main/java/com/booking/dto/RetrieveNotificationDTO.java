package com.booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RetrieveNotificationDTO {
    private String content;
    private Date creationTime;
    private boolean read;

    public RetrieveNotificationDTO() {
    }
    public RetrieveNotificationDTO(String content, Date creationTime, boolean read) {
    }
}
