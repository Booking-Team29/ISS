package com.booking.controller;
import com.booking.dto.Notification.NotificationDTO;
import com.booking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notification) {
        // implement service
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        List<NotificationDTO> notifications = this.notificationService.getAllNotifications();

        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }


    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/{id}"
    )
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        NotificationDTO notification = new NotificationDTO(); // implement service
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/user/{id}"
    )
    public ResponseEntity<List<NotificationDTO>> getNotificationsByUserId(@PathVariable Long id) {
        List<NotificationDTO> notifications = new ArrayList<>(); // implement service
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}