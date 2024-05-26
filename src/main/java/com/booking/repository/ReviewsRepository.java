package com.booking.repository;

import com.booking.domain.Review.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends GenericRepository<Review> {
    @Query(value = "select avg(r.rating) from Review r where r.accommodationId = :accommodationId", nativeQuery = true)
    public Double ratingForAccommodation(@Param("accommodationId") Long accommodationId);
}
