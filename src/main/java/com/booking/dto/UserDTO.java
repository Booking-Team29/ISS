package com.booking.dto;

import com.booking.domain.Account;
import com.booking.domain.UserStatus;
import com.booking.domain.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
        private Long UserId;
        private UserType userType;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String hashedPassword;
        private String homeAddress;
        private String phoneNumber;
        private UserStatus userStatus;

    public UserDTO(Long userId, UserType userType, String firstName, String lastName, String emailAddress, String hashedPassword, String homeAddress, String phoneNumber, UserStatus userStatus) {
        UserId = userId;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
    }

    public void FromUser(Account account) {
        this.UserId = account.getUserId();
        this.userType = account.getUserType();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.emailAddress = account.getEmailAddress();
        this.hashedPassword = account.getHashedPassword();
        this.homeAddress = account.getHomeAddress();
        this.phoneNumber = account.getPhoneNumber();
        this.userStatus = account.getUserStatus();
    }
}
