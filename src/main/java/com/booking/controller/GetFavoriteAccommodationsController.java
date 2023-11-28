package com.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/getFavoriteAccommodations")
public class GetFavoriteAccommodationsController {
    // TODO: implement
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Boolean>> getFavoriteAccommodations() {
        // Collection<Boolean> favoriteAccommodations = favoriteAccommodationService.findAll();

        // Boolean success = reviewService.delete(data);
        // if (success) {
        // return new ResponseEntity<Collection<Boolean>>(favoriteAccommodations, HttpStatus.OK);
        // }
        // return a 4XX status

        return new ResponseEntity<Collection<Boolean>>(HttpStatus.OK);
    }
}
