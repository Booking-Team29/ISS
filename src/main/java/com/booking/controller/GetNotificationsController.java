package com.booking.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/getNotifications")
public class GetNotificationsController {
    // TODO: implement
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Boolean>> getNotifications() {
        // Collection<Boolean> notifications = notificationService.findAll();

        // Boolean success = reviewService.delete(data);
        // if (success) {
        // return new ResponseEntity<Collection<Boolean>>(notifications, HttpStatus.OK);
        // }
        // return a 4XX status

        return new ResponseEntity<Collection<Boolean>>(HttpStatus.OK);
    }
}
