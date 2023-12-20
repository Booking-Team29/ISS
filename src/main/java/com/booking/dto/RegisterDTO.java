package com.booking.dto;

import com.booking.domain.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String address;
    private String phone;
    private UserType userType;
}
