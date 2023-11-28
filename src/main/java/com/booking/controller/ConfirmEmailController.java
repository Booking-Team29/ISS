package com.booking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/confirmEmail")
public class ConfirmEmailController {
    // TODO: implement
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> confirmEmail(@RequestBody Boolean data) throws Exception {
        // Boolean success = userService.confirmEmail(data);
        // if (success) {
           return new ResponseEntity<>(HttpStatus.CREATED);
        // }
        // return a 4XX status
    }
}