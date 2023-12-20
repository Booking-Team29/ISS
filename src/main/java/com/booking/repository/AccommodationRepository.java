package com.booking.repository;

import com.booking.domain.Accommodation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends GenericRepository<Accommodation> {

    public List<Accommodation> findAll();

    public Accommodation save(Accommodation accommodation);

    public void delete(Accommodation accommodation);

    @Query("SELECT f.accommodation FROM Favorite f WHERE f.user.id = :userId")
    List<Accommodation> findFavoritesByUserId(Long userId);
}