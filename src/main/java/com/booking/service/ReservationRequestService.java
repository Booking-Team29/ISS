package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;

public interface ReservationRequestService {
    public ReservationRequest save(ReservationRequest slot);
}
