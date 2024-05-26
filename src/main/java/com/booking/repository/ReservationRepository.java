package com.booking.repository;

import com.booking.domain.Reservation.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends GenericRepository<Reservation> {

    public List<Reservation> findAll();

    public Reservation save(Reservation reservation);

    public void delete(Reservation reservation);
}