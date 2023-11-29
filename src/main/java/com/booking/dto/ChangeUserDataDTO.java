package com.booking.dto;

import lombok.*;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class ChangeUserDataDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private int phone;

}
