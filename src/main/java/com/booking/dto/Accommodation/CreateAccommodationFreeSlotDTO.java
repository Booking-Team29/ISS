package com.booking.dto.Accommodation;

import lombok.*;

import java.time.LocalDate;
@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class CreateAccommodationFreeSlotDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long accommodationId;
    private Boolean available;
}


