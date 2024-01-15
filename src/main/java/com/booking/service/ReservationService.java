package com.booking.service;

import com.booking.domain.Reservation;
import com.booking.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    public Reservation findOne(Long id);

    public List<ReservationDTO> findAll();

    public Reservation saveReservation(ReservationDTO accommodation);

    public void deleteReservation(Reservation accommodation);
}
