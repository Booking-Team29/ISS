package com.booking.repository;

import com.booking.domain.Account;
import com.booking.dto.RegisterDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends GenericRepository<Account> {
    @Query(value = "select u from Account u where u.emailAddress = ?1")
    public Optional<Account> findOneByEmail(String email);

    public Account save(Account account);
}
