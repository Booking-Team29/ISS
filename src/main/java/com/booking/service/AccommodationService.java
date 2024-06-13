package com.booking.service;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.dto.Accommodation.AccommodationDTO;
import com.booking.dto.Accommodation.ApproveAccommodationDTO;
import com.booking.dto.Accommodation.ChangeAccommodationDTO;
import com.booking.dto.Accommodation.CreateAccommodationDTO;

import java.util.List;

public interface AccommodationService {
    public Accommodation findOne(Long id);

    public List<AccommodationDTO> findAll();

    public Accommodation saveAccommodation(CreateAccommodationDTO accommodation);

    public Accommodation approveAccommodation(ApproveAccommodationDTO accommodation);

    public Accommodation changeAccommodation(ChangeAccommodationDTO accommodation);

    public List<Accommodation> getFavoriteAccommodations(Long guestId);

    public List<Accommodation> getAccommodationsByOwnerId(Long ownerId);

    public void deleteAccommodation(Accommodation accommodation);

    public List<Accommodation> filterAccommodation(String destination, int numberOfPeople);
    public List<Accommodation> findAccommodationByUserId(Long userId);
}
