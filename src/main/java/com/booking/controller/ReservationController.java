package com.booking.controller;

import com.booking.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    @PostMapping(
            path = "/createReservation",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) {
        if (reservation == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ReservationDTO(), HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/getReservationRequests/{ownerId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ReservationDTO>> getReservationRequests(@PathVariable Long ownerId) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @GetMapping(
            path = "/getReservations/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ReservationDTO>> getReservations(@PathVariable Long userId) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @PutMapping(
            path = "/updateReservation/{reservationId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/deleteReservationRequest/{reservationId}")
    public ResponseEntity<Void> deleteReservationRequest(@PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}