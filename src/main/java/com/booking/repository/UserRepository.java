package com.booking.repository;

import com.booking.domain.User.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends GenericRepository<Account> {
    @Query(value = "select u from Account u where u.emailAddress = ?1")
    public Optional<Account> findOneByEmail(String email);
    @Query(value = "select u from Account  u where u.userId = ?1")
    public Optional<Account> findById(Long userId);
    public void delete(Account account);
    public Account save(Account account);
}
