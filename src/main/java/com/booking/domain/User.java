package com.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @Column(name="userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

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
    @Enumerated(EnumType.STRING)
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

    public User(Long userId, UserType userType, String firstName, String lastName, String emailAddress, String hashedPassword, String homeAddress, String phoneNumber, UserStatus userStatus) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.userType);
    }

    @Override
    public String getPassword() {
        return this.hashedPassword;
    }

    @Override
    public String getUsername() {
        return this.emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
