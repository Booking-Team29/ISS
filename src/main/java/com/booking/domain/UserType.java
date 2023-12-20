package com.booking.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    GUEST,
    OWNER,
    ADMIN;

    @Override
    public String getAuthority() { return this.toString(); }
}
