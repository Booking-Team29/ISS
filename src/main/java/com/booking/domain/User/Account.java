package com.booking.domain.User;

import com.booking.dto.User.RegisterDTO;
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
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Account")
public class Account implements UserDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @Column(name="usertype")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "emailaddress")
    private String emailAddress;

    @Column(name = "hashedpassword")
    private String hashedPassword;

    @Column(name = "homeaddress")
    private String homeAddress;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "userstatus")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    protected Account(long ID, String firstName, String lastName, String emailAddress, String hashedPassword,
                      String homeAddress, String phoneNumber, UserStatus userStatus) {
        this.userId = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
    }

    public Account(Long userId, UserType userType, String firstName, String lastName, String emailAddress, String hashedPassword, String homeAddress, String phoneNumber, UserStatus userStatus) {
        this.userId = userId;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
    }

    public void fromRegisterDTO(RegisterDTO dto) {
        this.userType = dto.getUserType();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.emailAddress = dto.getEmailAddress();
        this.hashedPassword = dto.getPassword();
        this.homeAddress = dto.getAddress();
        this.phoneNumber = dto.getPhone();
        this.userStatus = UserStatus.UNACTIVATED;
        this.userType = dto.getUserType();
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
