package com.booking.repository;

import com.booking.domain.Review.Review;
import com.booking.dto.Notification.NotificationDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.booking.domain.Notification.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends GenericRepository<Notification> {

        public Notification save(Notification notification);

        public List<Notification> findAll();

        @Query("SELECT n FROM Notification n WHERE n.userId = :id")
        public List<Notification> findByUserId(Long id);
}
