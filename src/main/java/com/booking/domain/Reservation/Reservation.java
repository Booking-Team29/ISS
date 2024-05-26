package com.booking.domain.Reservation;

import com.booking.dto.Reservation.ReservationDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import lombok.*;

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

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @Column(name = "guestcount")
    private int guestCount;

    @Column(name = "reservationstatus")
    private ReservationStatus status;

    @Column(name = "totalprice")
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

    public static Reservation fromReservationDTO(ReservationDTO reservationDTO) {
        return new Reservation(
                reservationDTO.getId(),
                reservationDTO.getStartDate(),
                reservationDTO.getEndDate(),
                reservationDTO.getGuestCount(),
                reservationDTO.getStatus(),
                reservationDTO.getTotalPrice()
        );
    }
}
