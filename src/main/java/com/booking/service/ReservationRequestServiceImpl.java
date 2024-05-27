package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;
import com.booking.repository.ReservationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationRequestServiceImpl implements  ReservationRequestService {
    @Autowired
    ReservationRequestRepository repository;

    public ReservationRequest save(ReservationRequest slot) {
        return repository.save(slot);
    }
}
