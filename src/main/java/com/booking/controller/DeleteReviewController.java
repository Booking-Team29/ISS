package com.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deleteReview")
public class DeleteReviewController {
    // TODO: implement
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable("id") Long id) {
        // Boolean success = reviewService.delete(data);
        // if (success) {
        return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
        // }
        // return a 4XX status
    }
}