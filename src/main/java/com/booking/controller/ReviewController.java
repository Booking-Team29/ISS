package com.booking.controller;
import com.booking.dto.CreateAccommodationReviewDTO;
import com.booking.dto.RetrieveAccommodationReviewDTO;
import com.booking.dto.CreateOwnerReviewDTO;
import com.booking.dto.RetrieveOwnerReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation"
    )
    public ResponseEntity<CreateAccommodationReviewDTO> createAccommodationReview(@RequestBody CreateAccommodationReviewDTO review) {
        // implement service

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation"
    )
    public ResponseEntity<List<RetrieveAccommodationReviewDTO>> getAccommodationReviews() {
        ArrayList<RetrieveAccommodationReviewDTO> reviews = new ArrayList<RetrieveAccommodationReviewDTO>() {}; // implement service
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation/{ownerId}"
    )
    public ResponseEntity<List<RetrieveAccommodationReviewDTO>> getAccommodationReviewsByOwnerId(@PathVariable Long ownerId) {
        List<RetrieveAccommodationReviewDTO> reviews = new ArrayList<>(); // implement service

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/owner"
    )
    public ResponseEntity<CreateOwnerReviewDTO> createOwnerReview(@RequestBody CreateOwnerReviewDTO review) {
        // implement service

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/owner/{ownerId}"
    )
    public ResponseEntity<List<RetrieveOwnerReviewDTO>> getOwnerReviewsById(@PathVariable Long ownerId) {
        List<RetrieveOwnerReviewDTO> reviews = new ArrayList<>(); // implement service

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{reviewId}"
    )
    public ResponseEntity<List<CreateOwnerReviewDTO>> deleteReview(@PathVariable Long reviewId) {
        List<CreateOwnerReviewDTO> reviews = new ArrayList<>(); // implement service

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}

