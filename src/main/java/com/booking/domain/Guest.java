package com.booking.domain;

public class Guest extends User {
    private GuestNotificationSettings notificationSettings;

    public Guest(
        long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
        String homeAddress, String phoneNumber, UserStatus userStatus
    ) {
        super(ID, firstName, lastName, emailAddress, hashedPassword, homeAddress, phoneNumber, userStatus);
        this.notificationSettings = new GuestNotificationSettings();
    }

    public GuestNotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(GuestNotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }
}