package com.booking.service;

import com.booking.domain.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    public Account save(Account account);
    public Optional<Account> findByEmail(String email);
}
