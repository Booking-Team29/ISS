package com.booking.repository;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.domain.Accommodation.ConfirmationMethod;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccommodationRepository extends GenericRepository<Accommodation> {

    public List<Accommodation> findAll();

    public Accommodation save(Accommodation accommodation);

    public void delete(Accommodation accommodation);

    @Query("SELECT a FROM Accommodation a WHERE a.ownerId = :userid")
    List<Accommodation> findAccommodationByUserId(Long userid);

    @Query("SELECT f.accommodation FROM Favorite f WHERE f.account.userId = :userId")
    List<Accommodation> findFavoritesByUserId(Long userId);

    @Query("SELECT a FROM Accommodation a WHERE a.location LIKE %:destination% AND :people >= a.minGuests and :people <= a.maxGuests")
    List<Accommodation> filterAccommodation( @Param("destination") String destination, @Param("people") int people
    );

    @Modifying
    @Transactional
    @Query("UPDATE Accommodation a SET a.confirmationMethod = :method WHERE a.ID = :id")
    public void setAccommodationConfirmationMethod(Long id, ConfirmationMethod method);
}