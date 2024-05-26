package com.booking.service;

import com.booking.domain.Reservation.Reservation;
import com.booking.dto.Reservation.ReservationDTO;
import com.booking.repository.ReservationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findOne(Long id) {
        // findById is an eager operation unlike getById
        // NOTE: findById returns an Optional<> type, so maybe it should be handled with .isPresent()
        return reservationRepository.findById(id).get();
    }

    public List<ReservationDTO> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        for (Reservation res: reservations) {
            reservationDTOs.add(ReservationDTO.fromReservation(res));
        }

        return reservationDTOs;
    }

    public Reservation saveReservation(ReservationDTO newReservation) {
        Reservation accommodation = Reservation.fromReservationDTO(newReservation);

        return reservationRepository.save(accommodation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
