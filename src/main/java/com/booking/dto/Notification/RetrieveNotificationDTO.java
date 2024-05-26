package com.booking.dto.Notification;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RetrieveNotificationDTO {
    private String content;
    private LocalDate creationTime;
    private boolean read;

    public RetrieveNotificationDTO() {
    }
    public RetrieveNotificationDTO(String content, LocalDate creationTime, boolean read) {
    }
}
