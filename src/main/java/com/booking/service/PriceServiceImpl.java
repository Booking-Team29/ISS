package com.booking.service;

import com.booking.domain.Accommodation.AccommodationFreeSlot;
import com.booking.domain.Accommodation.Price;
import com.booking.repository.AccommodationFreeSlotRepository;
import com.booking.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository repository;

    public Price savePrice(Price price) {
        return repository.save(price);
    }

}
