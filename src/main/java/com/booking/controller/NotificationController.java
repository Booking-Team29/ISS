package com.booking.controller;
import com.booking.domain.Notification.Notification;
import com.booking.domain.User.Account;
import com.booking.dto.Notification.NotificationDTO;
import com.booking.service.NotificationService;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private UserService userService;

    @Autowired
    public NotificationController(NotificationService notificationService, UserService userService) {
        this.notificationService = notificationService;
        this.userService = userService;
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
        return new ResponseEntity<>(this.notificationService.getNotificationById(id), HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/user"
    )
    @PreAuthorize("hasAnyAuthority('OWNER', 'GUEST', 'ADMIN')")
    public ResponseEntity<List<Notification>> getNotificationsByUserId() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();
        return new ResponseEntity<>(this.notificationService.getNotificationsByUserId(acc.getUserId()), HttpStatus.OK);
    }

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/user/{id}"
    )
    @PreAuthorize("hasAnyAuthority('OWNER', 'GUEST', 'ADMIN')")
    public ResponseEntity<Void> markNotificaitonRead(@PathVariable Long id) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();

        NotificationDTO noti = notificationService.getNotificationById(id);
        if (noti == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (noti.getUserId() != acc.getUserId()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        notificationService.markNotificationRead(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}