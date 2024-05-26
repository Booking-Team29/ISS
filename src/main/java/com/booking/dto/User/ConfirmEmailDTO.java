package com.booking.dto.User;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmEmailDTO {
    private String token;

    public ConfirmEmailDTO() {}

    public ConfirmEmailDTO(String token) {
        this.token = token;
    }
}
