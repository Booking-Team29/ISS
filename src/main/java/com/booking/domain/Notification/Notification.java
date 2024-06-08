package com.booking.domain.Notification;

import com.booking.dto.Notification.NotificationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationid")
    private Long notificationId;

    @Column(name = "content")
    private String content;

    @Column(name = "creationtime")
    private LocalDate creationTime;

    @Column(name = "read")
    private boolean read;

    @Column(name = "userid")
    private Long userId;
}