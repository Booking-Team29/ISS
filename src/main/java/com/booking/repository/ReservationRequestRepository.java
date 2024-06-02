package com.booking.repository;

import com.booking.domain.Reservation.ReservationRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public interface ReservationRequestRepository extends GenericRepository<ReservationRequest> {
    public ReservationRequest save(ReservationRequest slot);


    @Query("SELECT r FROM ReservationRequest r WHERE r.userId = :userId")
    public Collection<ReservationRequest> findAllForuser(Long userId);

    @Query("SELECT r FROM ReservationRequest r WHERE r.accommodationId = :accommodationId")
    public Collection<ReservationRequest> findAllForAccommodation(Long accommodationId);

    public Optional<ReservationRequest> findById(Long requestId);

    @Modifying
    @Transactional
    @Query("UPDATE ReservationRequest  r SET r.status = 5 WHERE r.id = :requestId")
    public void markRequestDeleted(Long requestId);

    @Modifying
    @Transactional
    @Query("UPDATE ReservationRequest  r SET r.status = 2 WHERE r.id = :requestId")
    public void markRequestDenied(Long requestId);

    @Modifying
    @Transactional
    @Query("UPDATE ReservationRequest  r SET r.status = 1 WHERE r.id = :requestId")
    public void markRequestApproved(Long requestId);

    @Modifying
    @Transactional
    @Query("UPDATE ReservationRequest  r SET r.status = 2 WHERE r.status = 0 and r.slotId = :slotId")
    public void denyAllRequestsForASlot(@Param("slotId") Long slotId);
}
