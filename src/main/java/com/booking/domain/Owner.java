package com.booking.domain;

public class Owner extends Account {
    private OwnerNotificationSettings notificationSettings;

    public Owner(
            Long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
            String homeAddress, String phoneNumber, UserStatus userStatus
    ) {
        super(ID, firstName, lastName, emailAddress, hashedPassword, homeAddress, phoneNumber, userStatus);
        this.notificationSettings = new OwnerNotificationSettings();
    }

    public OwnerNotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(OwnerNotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }
}
