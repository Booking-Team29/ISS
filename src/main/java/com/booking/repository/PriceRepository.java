package com.booking.repository;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.domain.Accommodation.Price;

public interface PriceRepository extends GenericRepository<Accommodation>{
    public Price save(Price price);
}
