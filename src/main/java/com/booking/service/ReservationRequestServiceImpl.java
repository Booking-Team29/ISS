package com.booking.service;

import com.booking.domain.Reservation.ReservationRequest;
import com.booking.repository.ReservationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    public Optional<ReservationRequest> findById(Long requestId) {
        return repository.findById(requestId);
    }

    public void markRequestDeleted(Long requestId) {
        this.repository.markRequestDeleted(requestId);
    }

    public void markRequestDenied(Long requestId) {
        this.repository.markRequestDenied(requestId);
    }

    public void markRequestApproved(Long requestId) {
        this.repository.markRequestApproved(requestId);
    }

    public void denyAllRequestsForASlot(Long slotId) {
        this.repository.denyAllRequestsForASlot(slotId);
    }
}
