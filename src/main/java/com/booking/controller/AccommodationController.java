package com.booking.controller;

import com.booking.domain.Accommodation;
import com.booking.dto.*;
import com.booking.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity<Accommodation> getAccommodation(@PathVariable Long accommodationId) {
        // I don't feel like writing another stupid fromAccommodation method so if it is needed it will be written
        Accommodation acc =  accommodationService.findOne(accommodationId);
        return new ResponseEntity<Accommodation>(acc, HttpStatus.OK);
    }

    // NOTE:  the last 2 methods are unimplemented
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(
            path = "/accommodationSearch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AccommodationDTO>> searchAccommodation(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Date start,
            @RequestParam(required = false) Date end,
            @RequestParam(required = false) Integer peopleNumber
            ) {
        //IMPLEMENT SERVICE
        Collection<AccommodationDTO> searchedAccommodations = new ArrayList<>();
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
