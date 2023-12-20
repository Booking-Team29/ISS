package com.booking.repository;

import com.booking.domain.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends GenericRepository<User> {
    @Query("select u from User u where u.emailAddress = ?1")
    public User findOneByEmail(String email);

    public User save(User user);
}
