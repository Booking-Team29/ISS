package com.booking.repository;

import com.booking.domain.Reservation.ReservationRequest;

public interface ReservationRequestRepository extends GenericRepository<ReservationRequest> {
    public ReservationRequest save(ReservationRequest slot);
}
