package com.booking.dto.User;

import lombok.*;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class LoginDTO {

    private String username;
    private String password;

}
