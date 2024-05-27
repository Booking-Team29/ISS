package com.booking.domain.Reservation;

import com.booking.dto.Reservation.ReservationRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "reservationrequest")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
public class ReservationRequest {
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

    @Column(name = "slotid")
    private Long slotId;

    public static ReservationRequest fromReservationRequestDTO(ReservationRequestDTO dto, Long userId) {
        return new ReservationRequest(
                null,
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getGuestsCount(),
                dto.getStatus(),
                dto.getTotalPrice(),
                userId,
                dto.getAccommodationId(),
                dto.getSlotId()
        );
    }
}
