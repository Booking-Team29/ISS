package com.booking.service;

import com.booking.domain.Accommodation;
import com.booking.domain.Reservation;

public interface ReservationService {
    public Reservation findOne(Long id);
}