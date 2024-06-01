package com.booking.service;

import com.booking.domain.Accommodation.AccommodationFreeSlot;
import com.booking.repository.AccommodationFreeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationFreeSlotServiceImpl implements AccommodationFreeSlotService {
    @Autowired
    private AccommodationFreeSlotRepository repository;


    public Optional<AccommodationFreeSlot> findOne(Long id) {
        return repository.findById(id);
    }

    public AccommodationFreeSlot saveAccommodationFreeSlot(AccommodationFreeSlot slot) {
        return repository.save(slot);
    }

    public void deleteAccommodationFreeSlot(AccommodationFreeSlot slot) {
        repository.delete(slot);
    }

    public List<AccommodationFreeSlot> findByAccommodationId(Long id) {
        return repository.findByAccommodationId(id);
    }

    public List<AccommodationFreeSlot> findAvailableByAccommodationId(Long accommodationId) {
        return repository.findAvailableByAccommodationId(accommodationId);
    }

}
