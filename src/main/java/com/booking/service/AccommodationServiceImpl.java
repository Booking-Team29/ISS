package com.booking.service;

import com.booking.domain.Accommodation;
import com.booking.repository.AccommodationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    public Accommodation findOne(Long id) {
        return accommodationRepository.getById(id);
    }
}
