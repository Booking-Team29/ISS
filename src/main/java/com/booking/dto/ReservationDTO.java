package com.booking.dto;

import com.booking.domain.ReservationStatus;
import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
public class ReservationDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private int guestCount;
    private ReservationStatus status;
    private int totalPrice;
}
