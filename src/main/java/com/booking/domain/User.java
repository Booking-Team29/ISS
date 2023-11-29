package com.booking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private long ID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String hashedPassword;
    private String homeAddress;
    private String phoneNumber;
    private UserStatus userStatus;
    protected User(long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
                   String homeAddress, String phoneNumber, UserStatus userStatus) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
    }

    // ToString method
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
