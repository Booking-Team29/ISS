package com.booking.controller;
import com.booking.dto.CreateNotificationDTO;
import com.booking.dto.RetrieveNotificationDTO;
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
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CreateNotificationDTO> createNotification(@RequestBody CreateNotificationDTO notification) {
        // implement service
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<RetrieveNotificationDTO>> getAllNotifications() {
        List<RetrieveNotificationDTO> notifications = new ArrayList<>(); // implement service
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }


    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    public ResponseEntity<RetrieveNotificationDTO> getNotificationById(@PathVariable Long id) {
        RetrieveNotificationDTO notification = new RetrieveNotificationDTO(); // implement service
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/user/{id}"
    )
    public ResponseEntity<List<RetrieveNotificationDTO>> getNotificationsByUserId(@PathVariable Long id) {
        List<RetrieveNotificationDTO> notifications = new ArrayList<>(); // implement service
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}

