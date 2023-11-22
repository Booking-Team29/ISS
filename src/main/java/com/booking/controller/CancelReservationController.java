package com.booking.controller;

import com.booking.domain.Accommodation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/cancelReservation")
public class CancelReservationController {
    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Accommodation>> cancelReservation() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
}
