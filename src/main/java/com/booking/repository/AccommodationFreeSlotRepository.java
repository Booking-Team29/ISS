package com.booking.repository;

import com.booking.domain.Accommodation.AccommodationFreeSlot;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AccommodationFreeSlotRepository extends GenericRepository<AccommodationFreeSlot>{
    @Query(value = "select u from AccommodationFreeSlot u where u.accommodationId = ?1")
    public List<AccommodationFreeSlot> findByAccommodationId(Long accommodationId);

    public AccommodationFreeSlot save(AccommodationFreeSlot slot);
}
