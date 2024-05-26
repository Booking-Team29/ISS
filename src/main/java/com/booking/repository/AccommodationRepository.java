package com.booking.repository;

import com.booking.domain.Accommodation.Accommodation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends GenericRepository<Accommodation> {

    public List<Accommodation> findAll();

    public Accommodation save(Accommodation accommodation);

    public void delete(Accommodation accommodation);

    @Query("SELECT f.accommodation FROM Favorite f WHERE f.account.userId = :userId")
    List<Accommodation> findFavoritesByUserId(Long userId);

    @Query("SELECT a FROM Accommodation a WHERE a.location LIKE %:destination% AND :people >= a.minGuests and :people <= a.maxGuests")
    List<Accommodation> filterAccommodation( @Param("destination") String destination, @Param("people") int people
    );
}