package com.booking.domain.User;

import com.booking.domain.Notification.AdminNotificationSettings;

public class Admin extends Account {
    private AdminNotificationSettings notificationSettings;

    public Admin(
            Long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
            String homeAddress, String phoneNumber, UserStatus userStatus
    ) {
        super(ID, firstName, lastName, emailAddress, hashedPassword, homeAddress, phoneNumber, userStatus);
        this.notificationSettings = new AdminNotificationSettings();
    }

    public AdminNotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(AdminNotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }
}
