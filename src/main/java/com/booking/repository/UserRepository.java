package com.booking.repository;

import com.booking.domain.Account;
import com.booking.dto.RegisterDTO;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends GenericRepository<Account> {
    @Query(value = "select u from Account u where u.emailAddress = ?1")
    public Account findOneByEmail(String email);

    public Account save(Account account);
}
