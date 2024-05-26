package com.booking.domain.Notification;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Notification {

    private Long notificationId;
    private String content;
    private LocalDate creationTime;
    private boolean read;
    public Notification() {
    }
}
