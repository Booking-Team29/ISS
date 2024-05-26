package com.booking.dto.User;

import com.booking.domain.User.UserType;
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
