package com.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/changeAccommodationDataController")
public class ChangeAccommodationDataController {

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> changeAccommodationDataController() {
        //TODO : proper response message
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
