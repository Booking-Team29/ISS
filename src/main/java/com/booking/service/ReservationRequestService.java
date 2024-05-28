package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;

import java.util.Collection;

public interface ReservationRequestService {
    public ReservationRequest save(ReservationRequest slot);
    public Collection<ReservationRequest> findAllForuser(Long userId);
    public Collection<ReservationRequest> findAllForAccommodation(Long accommodationId);
}
