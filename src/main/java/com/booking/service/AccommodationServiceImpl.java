package com.booking.service;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.dto.Accommodation.AccommodationDTO;
import com.booking.dto.Accommodation.ApproveAccommodationDTO;
import com.booking.dto.Accommodation.ChangeAccommodationDTO;
import com.booking.dto.Accommodation.CreateAccommodationDTO;
import com.booking.repository.AccommodationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    public Accommodation findOne(Long id) {
        // findById is an eager operation unlike getById
        // NOTE: findById returns an Optional<> type, so maybe it should be handled with .isPresent()
        return accommodationRepository.findById(id).get();
    }

    public List<AccommodationDTO> findAll() {
        List<Accommodation> accommodations = accommodationRepository.findAll();

        List<AccommodationDTO> accommodationDTOs = new ArrayList<>();
        for (Accommodation acc: accommodations) {
            accommodationDTOs.add(AccommodationDTO.fromAccommodation(acc));
        }

        return accommodationDTOs;
    }

    public Accommodation saveAccommodation(CreateAccommodationDTO newAccommodation) {
        Accommodation accommodation = Accommodation.fromCreateDTO(newAccommodation);

        return accommodationRepository.save(accommodation);
    }

    public Accommodation approveAccommodation(ApproveAccommodationDTO newAccommodation) {
        Accommodation accommodation = Accommodation.fromApproveDTO(newAccommodation);

        return accommodationRepository.save(accommodation);
    }

    public Accommodation changeAccommodation(ChangeAccommodationDTO newAccommodation) {
        Accommodation accommodation = Accommodation.fromChangeDTO(newAccommodation);

        return accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(Accommodation accommodation) {
        accommodationRepository.delete(accommodation);
    }

    public void deleteAccommodationById(Accommodation accommodation) {
        accommodationRepository.deleteById(accommodation.getID());
    }

    public List<Accommodation> getFavoriteAccommodations(Long guestId) {
        return accommodationRepository.findFavoritesByUserId(guestId);
    }

    public List<Accommodation> filterAccommodation(String destination, int numberOfPeople) {
        return accommodationRepository.filterAccommodation(destination, numberOfPeople);
    }

    public List<Accommodation> findAccommodationByUserId(Long userId) {
        return accommodationRepository.findAccommodationByUserId(userId);
    }
}
