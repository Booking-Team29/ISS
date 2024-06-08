package com.booking.controller;

import com.booking.Helpers;
import com.booking.domain.Accommodation.Accommodation;
import com.booking.dto.Accommodation.*;
import com.booking.service.AccommodationFreeSlotService;
import com.booking.service.AccommodationService;
import com.booking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/accommodation")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT},
        allowedHeaders = "*"
)
public class AccommodationController {
    private AccommodationService accommodationService;
    private ReviewService reviewService;
    private AccommodationFreeSlotService slotService;

    @Autowired
    public AccommodationController(AccommodationService service, ReviewService review, AccommodationFreeSlotService accommodationFreeSlotService) {
        this.accommodationService = service;
        this.reviewService = review;
        this.slotService = accommodationFreeSlotService;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AccommodationDTO>> getAllAccommodations() {
        List<AccommodationDTO> accs =  accommodationService.findAll();

        return new ResponseEntity<>(accs, HttpStatus.OK);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('OWNER')")
    public ResponseEntity<?> createAccommodation(@RequestBody CreateAccommodationDTO newAccommodation) {
        Accommodation accommodation = accommodationService.saveAccommodation(newAccommodation);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PutMapping(
            path = "/approve/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> approveAccommodation(@RequestBody ApproveAccommodationDTO approveAccommodation,
                                                  @PathVariable Long accommodationId) {

        Accommodation accommodation = accommodationService.approveAccommodation(approveAccommodation);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PutMapping(
            path = "/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE

    )
    @PreAuthorize("hasAnyAuthority('OWNER')")
    public ResponseEntity<?> changeAccommodationData(@PathVariable Long accommodationId,
                                                                     @RequestBody ChangeAccommodationDTO changeAccommodationData) {
        Accommodation accommodation = accommodationService.changeAccommodation(changeAccommodationData);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @GetMapping(
            path = "/favorite/{guestId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<List<Accommodation>> getFavoriteAccommodations(@PathVariable Long guestId) {

        List<Accommodation> accommodations = accommodationService.getFavoriteAccommodations(guestId);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetAccommodationDTO> getAccommodation(@PathVariable Long accommodationId) {
        Accommodation acc =  accommodationService.findOne(accommodationId);
        GetAccommodationDTO accommodation = GetAccommodationDTO.fromAccommodation(acc);
        accommodation.setSlots(slotService.findAvailableByAccommodationId(accommodationId));
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @GetMapping(
            path = "/accommodationSearch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AccommodationFilterDTO>> searchAccommodation(
            @RequestParam(required = true) String location,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end,
            @RequestParam(required = true) Integer peopleNumber
            ) {
        Collection<Accommodation> accs = accommodationService.filterAccommodation(location, peopleNumber);
        if (start != null && end != null) {
            accs = accs.stream().filter(a -> Helpers.isAccommodationFreeInAnyPeriod(slotService.findAvailableByAccommodationId(a.getID()), start, end))
                    .collect(Collectors.toList());
        }
        Collection<AccommodationFilterDTO> filterDTOS =
                accs
                .stream()
                .map(a -> AccommodationFilterDTO.fromAccommodation(a, this.reviewService.accommodationRating(a.getID()).orElse(0d)))
                .toList();

        return new ResponseEntity<Collection<AccommodationFilterDTO>>(filterDTOS, HttpStatus.OK);
    }

    @PutMapping(
            path = "/define/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('OWNER')")
    public ResponseEntity<?> defineReservationType(@RequestBody AccommodationDTO defineReservationType,
                                                  @PathVariable Long accommodationId) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(defineReservationType, HttpStatus.OK);
    }
}
