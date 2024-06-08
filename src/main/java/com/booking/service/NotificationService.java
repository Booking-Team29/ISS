package com.booking.service;

import com.booking.dto.Notification.NotificationDTO;

import java.util.List;

public interface NotificationService {
    public void createNotification(NotificationDTO notification);
    public List<NotificationDTO> getAllNotifications();
    public NotificationDTO getNotificationById(Long id);
}
