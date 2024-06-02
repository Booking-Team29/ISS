package com.booking.service;

import com.booking.domain.Accommodation.AccommodationFreeSlot;

import java.util.List;
import java.util.Optional;

public interface AccommodationFreeSlotService {
    public Optional<AccommodationFreeSlot> findOne(Long id);

    public AccommodationFreeSlot saveAccommodationFreeSlot(AccommodationFreeSlot slot);

    public void deleteAccommodationFreeSlot(AccommodationFreeSlot slot);

    public List<AccommodationFreeSlot> findByAccommodationId(Long id);
    public List<AccommodationFreeSlot> findAvailableByAccommodationId(Long accommodationId);

    public void disableSlot(Long slotId);

}
