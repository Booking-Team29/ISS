package com.booking.service;

import com.booking.domain.User.Account;
import com.booking.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.booking.domain.User.UserStatus;

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
    public Optional<Account> findById(Long id) {

        return userRepository.findById(id);
    }

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

    // the following method is used for blocking a user (setting the users status to BLOCKED)
    public void blockUser(Long userId) {
        Optional<Account> acc = userRepository.findById(userId);
        if (acc.isEmpty()) throw new UsernameNotFoundException("Invalid credentials");
        acc.get().setUserStatus(UserStatus.BLOCKED);
        userRepository.save(acc.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Account> acc = userRepository.findById(id);
        if (acc.isEmpty()) throw new UsernameNotFoundException("Invalid credentials");
        acc.get().setUserStatus(UserStatus.DELETED);
        userRepository.save(acc.get());
    }
}
