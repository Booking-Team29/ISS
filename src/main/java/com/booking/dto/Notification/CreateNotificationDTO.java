package com.booking.dto.Notification;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateNotificationDTO {
    private String content;
    private LocalDate creationTime;
    private boolean read;

    public CreateNotificationDTO() {}

    public CreateNotificationDTO(String content, LocalDate creationTime, boolean read) {}
}
