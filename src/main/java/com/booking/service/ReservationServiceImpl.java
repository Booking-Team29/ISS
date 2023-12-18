package com.booking.service;

import com.booking.domain.Reservation;
import com.booking.repository.ReservationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findOne(Long id) {
        return reservationRepository.getById(id);
    }

}
