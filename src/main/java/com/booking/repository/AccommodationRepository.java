package com.booking.repository;

import com.booking.domain.Accommodation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends GenericRepository<Accommodation> {
    public Accommodation getById(Long id);
}