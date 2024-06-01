package com.booking.repository;

import com.booking.domain.Reservation.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends GenericRepository<Reservation> {

    public List<Reservation> findAll();

    public Reservation save(Reservation reservation);

    public void delete(Reservation reservation);

    @Query("SELECT r FROM Reservation r WHERE r.userId = :userId")
    public List<Reservation> findReservationByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.status = 6 WHERE r.id = :reservationId")
    public void markReservationCancelled(Long reservationId);
}