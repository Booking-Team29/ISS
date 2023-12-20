package com.booking.domain;

import java.time.LocalDate;

public class Reservation {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int guestCount;
    private ReservationStatus status;
    private int totalPrice;

    public Reservation(Long id, LocalDate startDate, LocalDate endDate, int guestCount,
                       ReservationStatus status, int totalPrice) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestCount = guestCount;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    // Getters and setters for each field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // ToString method to represent reservation details as a String
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", guestCount=" + guestCount +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
