package com.booking.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    Guest,
    Owner,
    Admin;

    @Override
    public String getAuthority() { return this.toString(); }
}
