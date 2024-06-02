package com.booking.dto.Reservation;

import com.booking.domain.Reservation.Reservation;
import com.booking.domain.Reservation.ReservationStatus;
import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int guestsCount;
    private ReservationStatus status;
    private int totalPrice;
    private Long userId;
    private Long accommodationId;

    public static ReservationDTO fromReservation(Reservation reservation) {
        return new ReservationDTO (
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuestsCount(),
                reservation.getStatus(),
                reservation.getTotalPrice(),
                reservation.getUserId(),
                reservation.getAccommodationId()
        );
    }
}
