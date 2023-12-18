package com.booking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "accommodation")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "guestCount")
    private int guestCount;

    @Column(name = "reservationStatus")
    private ReservationStatus status;

    @Column(name = "totalPrice")
    private int totalPrice;

    public Reservation(Long id, Date startDate, Date endDate, int guestCount,
                       ReservationStatus status, int totalPrice) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestCount = guestCount;
        this.status = status;
        this.totalPrice = totalPrice;
    }
}