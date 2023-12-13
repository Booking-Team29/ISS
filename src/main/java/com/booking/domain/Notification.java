package com.booking.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Notification {

    private Long notificationId;
    private String content;
    private Date creationTime;
    private boolean read;
    public Notification() {
    }
}
