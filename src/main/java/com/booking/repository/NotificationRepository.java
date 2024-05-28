package com.booking.repository;

import com.booking.dto.Notification.CreateNotificationDTO;
import org.springframework.stereotype.Repository;
import com.booking.domain.Notification.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends GenericRepository<Notification> {

        public Notification save(Notification notification);

        public List<Notification> findAll();
}
