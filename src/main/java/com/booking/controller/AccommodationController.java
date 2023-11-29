package com.booking.controller;

import com.booking.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/accommodation")
public class AccommodationController {

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createAccommodation(@RequestBody CreateAccommodationDTO newAccommodation) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(newAccommodation, HttpStatus.OK);
    }

    @PutMapping(
            path = "/approve/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> approveAccommodation(@RequestBody ApproveAccommodationDTO approveAccommodation,
                                                  @PathVariable Long id) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(approveAccommodation, HttpStatus.OK);
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE

    )
    public ResponseEntity<?> changeAccommodationData(@PathVariable Long accommodationId,
                                                                     @RequestBody ChangeAccommodationDTO changeAccommodationData) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(changeAccommodationData, HttpStatus.OK);
    }

    @GetMapping(
            path = "/favorite/{guestId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AccommodationDTO>> getFavoriteAccommodations(@PathVariable Long guestId) {
        //IMPLEMENT SERVICE
        Collection<AccommodationDTO> favoriteAccommodations = new ArrayList<>();

        return new ResponseEntity<Collection<AccommodationDTO>>(favoriteAccommodations, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{accommodationId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetAccommodationDTO> getAccommodation(@PathVariable Long id) {
        //IMPLEMENT SERVICE
        GetAccommodationDTO accommodation = new GetAccommodationDTO();
        return new ResponseEntity<GetAccommodationDTO>(accommodation, HttpStatus.OK);
    }
    @GetMapping(
            path = "/accommodationSearch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AccommodationDTO>> searchAccommodation(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Date start,
            @RequestParam(required = false) Date end,
            @RequestParam(required = false) int peopleNumber
            ) {
        //IMPLEMENT SERVICE
        Collection<AccommodationDTO> searchedAccommodations = new ArrayList<>();
        return new ResponseEntity<Collection<AccommodationDTO>>(searchedAccommodations, HttpStatus.OK);
    }

    @PutMapping(
            path = "/define/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> defineReservationType(@RequestBody AccommodationDTO defineReservationType,
                                                  @PathVariable Long id) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(defineReservationType, HttpStatus.OK);
    }



}
