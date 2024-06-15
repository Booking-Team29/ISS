package com.booking.dto.User;

import lombok.*;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class ChangeUserDataDTO {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String homeAddress;
    private String phoneNumber;

}
