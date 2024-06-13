package com.booking.dto.Accommodation;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class AccommodationFreeSlotDTO {

    private Long ID;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long accommodationId;
    private Boolean available;

}
