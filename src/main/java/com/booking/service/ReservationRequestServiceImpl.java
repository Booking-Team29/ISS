package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;
import com.booking.repository.ReservationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReservationRequestServiceImpl implements  ReservationRequestService {
    @Autowired
    ReservationRequestRepository repository;

    public ReservationRequest save(ReservationRequest slot) {
        return repository.save(slot);
    }

    public Collection<ReservationRequest> findAllForuser(Long userId) {
        return repository.findAllForuser(userId);
    }

    public Collection<ReservationRequest> findAllForAccommodation(Long accommodationId) {
        return repository.findAllForAccommodation(accommodationId);
    }
}
