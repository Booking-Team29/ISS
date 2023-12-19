package com.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "hashedPassword")
    private String hashedPassword;

    @Column(name = "homeAddress")
    private String homeAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "userStatus")
    private UserStatus userStatus;
    protected User(long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
                   String homeAddress, String phoneNumber, UserStatus userStatus) {
        this.UserId = ID;
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
