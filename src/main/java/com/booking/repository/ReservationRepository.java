package com.booking.repository;

import com.booking.domain.Accommodation;
import com.booking.domain.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends GenericRepository<Reservation> {
    public Reservation getById(Long id);
}