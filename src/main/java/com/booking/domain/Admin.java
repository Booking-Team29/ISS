package com.booking.domain;

public class Admin extends User {
    private AdminNotificationSettings notificationSettings;

    public Admin(
            long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
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
