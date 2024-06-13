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

    public static Notification fromNotificationDTO(NotificationDTO dto) {
        if (dto == null) {
            return null;
        }
        Notification notification = new Notification();
        notification.setContent(dto.getContent());
        notification.setCreationTime(dto.getCreationTime());
        notification.setRead(dto.isRead());
        notification.setUserId(dto.getUserId());
        return notification;
    }

    public static NotificationDTO toNotificationDTO(Notification notification) {
        return new NotificationDTO(
                notification.getContent(),
                notification.getCreationTime(),
                notification.isRead(),
                notification.getUserId()
        );
    }
}