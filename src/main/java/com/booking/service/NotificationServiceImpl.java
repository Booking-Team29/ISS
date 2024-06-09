package com.booking.service;

import com.booking.domain.Notification.Notification;
import com.booking.dto.Notification.NotificationDTO;
import com.booking.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification(); // Assume Notification is an entity class
        // Map fields from DTO to entity
        notificationRepository.save(notification); // Save to database
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(Notification::toNotificationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id).orElse(null); // Find the notification
        NotificationDTO dto = Notification.toNotificationDTO(notification);
        return dto;
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long id) {
        return notificationRepository.findByUserId(id).stream()
                .map(Notification::toNotificationDTO)
                .collect(Collectors.toList());
    }
}
