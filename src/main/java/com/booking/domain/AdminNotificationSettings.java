package com.booking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminNotificationSettings {

    private boolean commentReport;
    private boolean userReport;

    public AdminNotificationSettings(){
    }
}
