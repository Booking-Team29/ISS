package com.booking.dto;

import com.booking.domain.ReservationStatus;
import lombok.*;

import java.util.Date;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
public class ReservationDTO {
    private Date startDate;
    private Date endDate;
    private int guestCount;
    private ReservationStatus status;
    private int totalPrice;
}
