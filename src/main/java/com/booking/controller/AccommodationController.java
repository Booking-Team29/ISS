package com.booking.controller;

import com.booking.domain.Accommodation;
import com.booking.dto.*;
import com.booking.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    @Autowired
    public AccommodationController(AccommodationService service) {
        this.accommodationService = service;
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
    public ResponseEntity<?> createAccommodation(@RequestBody CreateAccommodationDTO newAccommodation) {
        Accommodation accommodation = accommodationService.saveAccommodation(newAccommodation);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PutMapping(
            path = "/approve/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
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
    public ResponseEntity<?> changeAccommodationData(@PathVariable Long accommodationId,
                                                                     @RequestBody ChangeAccommodationDTO changeAccommodationData) {
        Accommodation accommodation = accommodationService.changeAccommodation(changeAccommodationData);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @GetMapping(
            path = "/favorite/{guestId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Accommodation>> getFavoriteAccommodations(@PathVariable Long guestId) {

        List<Accommodation> accommodations = accommodationService.getFavoriteAccommodations(guestId);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AccommodationDTO> getAccommodation(@PathVariable Long accommodationId) {
        Accommodation acc =  accommodationService.findOne(accommodationId);
        AccommodationDTO accommodation = AccommodationDTO.fromAccommodation(acc);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    // NOTE:  the last 2 methods are unimplemented
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(
            path = "/accommodationSearch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AccommodationDTO>> searchAccommodation(
            @RequestParam(required = true) String location,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end,
            @RequestParam(required = true) Integer peopleNumber
            ) {
        Collection<Accommodation> accs = accommodationService.filterAccommodation(location, peopleNumber);
        if (start != null && end != null) {
            accs = accs.stream().filter(a -> a.getAvailableDates().stream().noneMatch(date ->
                    (start.isBefore(date.getStartDate()) || start.isEqual(date.getStartDate())) && (end.isAfter(date.getEndDate()) || end.isEqual(date.getEndDate()))
                )).collect(Collectors.toList());
        }
        Collection<AccommodationDTO> searchedAccommodations = accs.stream().map(AccommodationDTO::fromAccommodation).collect(Collectors.toList());
        return new ResponseEntity<Collection<AccommodationDTO>>(searchedAccommodations, HttpStatus.OK);
    }

    @PutMapping(
            path = "/define/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> defineReservationType(@RequestBody AccommodationDTO defineReservationType,
                                                  @PathVariable Long accommodationId) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(defineReservationType, HttpStatus.OK);
    }
}
