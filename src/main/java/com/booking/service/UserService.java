package com.booking.service;

import com.booking.domain.User.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    public Account save(Account account);
    public Optional<Account> findByEmail(String email);
    public void blockUser(Long userId);
    public Account findById(Long id);
}
