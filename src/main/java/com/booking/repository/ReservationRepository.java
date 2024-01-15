package com.booking.repository;

import com.booking.domain.Accommodation;
import com.booking.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends GenericRepository<Reservation> {

    public List<Reservation> findAll();

    public Reservation save(Reservation reservation);

    public void delete(Reservation reservation);
}