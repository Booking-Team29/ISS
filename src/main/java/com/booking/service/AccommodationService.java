package com.booking.service;

import com.booking.domain.Accommodation;
import com.booking.dto.AccommodationDTO;
import com.booking.dto.ApproveAccommodationDTO;
import com.booking.dto.ChangeAccommodationDTO;
import com.booking.dto.CreateAccommodationDTO;

import java.util.List;

public interface AccommodationService {
    public Accommodation findOne(Long id);

    public List<AccommodationDTO> findAll();

    public Accommodation saveAccommodation(CreateAccommodationDTO accommodation);

    public Accommodation approveAccommodation(ApproveAccommodationDTO accommodation);

    public Accommodation changeAccommodation(ChangeAccommodationDTO accommodation);

    public List<Accommodation> getFavoriteAccommodations(Long guestId);

    public void deleteAccommodation(Accommodation accommodation);

    public List<Accommodation> filterAccommodation(String destination, int numberOfPeople);
}
