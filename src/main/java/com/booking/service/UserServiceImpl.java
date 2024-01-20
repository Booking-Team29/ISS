package com.booking.service;

import com.booking.domain.Account;
import com.booking.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Account save(Account account) {
        account.setHashedPassword(passwordEncoder.encode(account.getPassword()));
        return userRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> acc = userRepository.findOneByEmail(username);
        if (acc.isEmpty()) throw new UsernameNotFoundException("Invalid credentials");
        return acc.get();
    }
}
