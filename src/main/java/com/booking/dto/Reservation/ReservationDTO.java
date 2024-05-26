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
    private int guestCount;
    private ReservationStatus status;
    private int totalPrice;

    public static ReservationDTO fromReservation(Reservation reservation) {
        return new ReservationDTO (
                reservation.getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuestCount(),
                reservation.getStatus(),
                reservation.getTotalPrice()
        );
    }
}
