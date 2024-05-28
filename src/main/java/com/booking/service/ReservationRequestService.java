package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;

import java.util.Collection;
import java.util.Optional;

public interface ReservationRequestService {
    public ReservationRequest save(ReservationRequest slot);
    public Collection<ReservationRequest> findAllForuser(Long userId);
    public Collection<ReservationRequest> findAllForAccommodation(Long accommodationId);
    public Optional<ReservationRequest> findById(Long requestId);
    public void markRequestDeleted(Long requestId);
    public void markRequestDenied(Long requestId);
}
