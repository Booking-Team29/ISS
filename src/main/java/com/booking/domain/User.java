package com.booking.domain;

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

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
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
