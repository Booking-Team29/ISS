package com.booking.controller;

import com.booking.dto.Reservation.ReservationDTO;
import com.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT},
        allowedHeaders = "*"
)
public class ReservationController {
    private ReservationService _reservationService;


    @Autowired
    public ReservationController(ReservationService service) {
        this._reservationService = service;
    }


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservationRequests() {
        List<ReservationDTO> reservations = this._reservationService.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) {
        if (reservation == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ReservationDTO(), HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/reservationRequests/{ownerId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservationRequests(@PathVariable Long ownerId) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @GetMapping(
            path = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservations(@PathVariable Long userId) {
         this._reservationService.findOne(userId);

        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @PutMapping(
            path = "/{reservationId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/reservationRequest/{reservationId}"
    )
    public ResponseEntity<Void> deleteReservationRequest(@PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}