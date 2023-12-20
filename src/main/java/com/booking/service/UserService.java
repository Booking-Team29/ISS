package com.booking.service;

import com.booking.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User save(User user);
    public User findByEmail(String email);
}
