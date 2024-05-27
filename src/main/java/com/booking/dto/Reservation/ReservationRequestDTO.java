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
public class ReservationRequestDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int guestsCount;
    private ReservationStatus status;
    private int totalPrice;
    private String userEmail;
    private Long accommodationId;
    private Long slotId;
}
