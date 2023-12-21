package com.booking.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.util.List;
import com.booking.dto.ReservationDTO;

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
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "guestCount")
    private int guestCount;

    @Column(name = "reservationStatus")
    private ReservationStatus status;

    @Column(name = "totalPrice")
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
