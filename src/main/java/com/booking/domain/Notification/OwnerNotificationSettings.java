package com.booking.domain.Notification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OwnerNotificationSettings {

    private boolean reservationCreation;
    private boolean reservationCancellation;
    private boolean OwnerRating;
    private boolean AccommodationRating;

    public OwnerNotificationSettings(){
    }
}
