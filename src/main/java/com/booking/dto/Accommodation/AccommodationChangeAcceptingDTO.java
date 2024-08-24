package com.booking.dto.Accommodation;

import com.booking.domain.Accommodation.ConfirmationMethod;
import lombok.*;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationChangeAcceptingDTO {
    public com.booking.domain.Accommodation.ConfirmationMethod ConfirmationMethod;
}
