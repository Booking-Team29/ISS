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
    private String email;
    private String username;
    private String password;
    private String address;
    private int phone;

}
