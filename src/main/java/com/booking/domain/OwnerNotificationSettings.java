package com.booking.domain;

public class OwnerNotificationSettings {

    private boolean reservationCreation;
    private boolean reservationCancellation;
    private boolean OwnerRating;
    private boolean AccommodationRating;

    public OwnerNotificationSettings(){

    }

    public boolean isReservationCreation() {
        return reservationCreation;
    }

    public void setReservationCreation(boolean reservationCreation) {
        this.reservationCreation = reservationCreation;
    }

    public boolean isReservationCancellation() {
        return reservationCancellation;
    }

    public void setReservationCancellation(boolean reservationCancellation) {
        this.reservationCancellation = reservationCancellation;
    }

    public boolean isOwnerRating() {
        return OwnerRating;
    }

    public void setOwnerRating(boolean ownerRating) {
        OwnerRating = ownerRating;
    }

    public boolean isAccommodationRating() {
        return AccommodationRating;
    }

    public void setAccommodationRating(boolean accommodationRating) {
        AccommodationRating = accommodationRating;
    }
}
