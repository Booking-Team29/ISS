package com.booking.service;

import com.booking.dto.Notification.CreateNotificationDTO;
import com.booking.dto.Notification.RetrieveNotificationDTO;

import java.util.List;

public interface NotificationService {
    public void createNotification(CreateNotificationDTO notification);
    public List<RetrieveNotificationDTO> getAllNotifications();
    public RetrieveNotificationDTO getNotificationById(Long id);
}
