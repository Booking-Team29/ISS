package com.booking.repository;

import com.booking.domain.Accommodation.AccommodationFreeSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccommodationFreeSlotRepository extends GenericRepository<AccommodationFreeSlot>{
    @Query(value = "select u from AccommodationFreeSlot u where u.accommodationId = ?1")
    public List<AccommodationFreeSlot> findByAccommodationId(Long accommodationId);

    @Query(value = "select u from AccommodationFreeSlot u where u.accommodationId = ?1 and u.available = true")
    public List<AccommodationFreeSlot> findAvailableByAccommodationId(Long accommodationId);

    @Modifying
    @Transactional
    @Query("UPDATE AccommodationFreeSlot s SET s.available = false WHERE s.ID = :slotId")
    public void disableSlot(Long slotId);

    public AccommodationFreeSlot save(AccommodationFreeSlot slot);
}
