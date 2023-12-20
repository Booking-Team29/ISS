package com.booking.service;

import com.booking.domain.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public Account save(Account account);
    public Account findByEmail(String email);
}
