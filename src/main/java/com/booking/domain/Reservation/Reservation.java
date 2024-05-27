package com.booking.domain.Reservation;

import com.booking.dto.Reservation.ReservationDTO;
import com.booking.dto.Reservation.ReservationRequestDTO;
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
@Table(name = "reservation")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @Column(name = "guestscount")
    private int guestsCount;

    @Column(name = "status")
    private ReservationStatus status;

    @Column(name = "totalprice")
    private int totalPrice;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "accommodationid")
    private Long accommodationId;

    public static Reservation fromReservationDTO(ReservationDTO reservationDTO) {
        return new Reservation(
                reservationDTO.getId(),
                reservationDTO.getStartDate(),
                reservationDTO.getEndDate(),
                reservationDTO.getGuestsCount(),
                reservationDTO.getStatus(),
                reservationDTO.getTotalPrice(),
                reservationDTO.getUserId(),
                reservationDTO.getAccommodationId()
        );
    }

    public static Reservation fromReservationRequest(ReservationRequest reservationRequest) {
        return new Reservation(
                reservationRequest.getId(),
                reservationRequest.getStartDate(),
                reservationRequest.getEndDate(),
                reservationRequest.getGuestsCount(),
                reservationRequest.getStatus(),
                reservationRequest.getTotalPrice(),
                reservationRequest.getUserId(),
                reservationRequest.getAccommodationId()
        );

    }

    public static Reservation fromReservationRequestDTO(ReservationRequestDTO reservationRequest, Long userId) {
        return new Reservation(
                reservationRequest.getId(),
                reservationRequest.getStartDate(),
                reservationRequest.getEndDate(),
                reservationRequest.getGuestsCount(),
                reservationRequest.getStatus(),
                reservationRequest.getTotalPrice(),
                userId,
                reservationRequest.getAccommodationId()
        );

    }

}
