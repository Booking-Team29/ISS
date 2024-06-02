package com.booking.domain;

import java.util.Date;

public class Reservation {
    private int id;
    private Date startDate;
    private Date endDate;
    private int guestCount;
    private ReservationStatus status;
    private int totalPrice;

    public Reservation(int id, Date startDate, Date endDate, int guestCount,
                       ReservationStatus status, int totalPrice) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestCount = guestCount;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    // Getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
