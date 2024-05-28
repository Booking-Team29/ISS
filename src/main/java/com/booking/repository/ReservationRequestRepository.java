package com.booking.repository;

import com.booking.domain.Reservation.ReservationRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ReservationRequestRepository extends GenericRepository<ReservationRequest> {
    public ReservationRequest save(ReservationRequest slot);


    @Query("SELECT r FROM ReservationRequest r WHERE r.userId = :userId")
    public Collection<ReservationRequest> findAllForuser(Long userId);

    @Query("SELECT r FROM ReservationRequest r WHERE r.accommodationId = :accommodationId")
    public Collection<ReservationRequest> findAllForAccommodation(Long accommodationId);
}
