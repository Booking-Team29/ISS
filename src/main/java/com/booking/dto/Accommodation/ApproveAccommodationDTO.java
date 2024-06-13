package com.booking.dto.Accommodation;

import com.booking.domain.Accommodation.AccommodationType;
import com.booking.domain.Accommodation.ConfirmationMethod;
import com.booking.domain.Accommodation.Price;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class ApproveAccommodationDTO {

    private Long ID;
    private String Name;
    private String Description;
    private String Location;
    private List<Float> LocationCoordinates;
    private int MinGuests;
    private int MaxGuests;
    private List<Price> prices;
    private com.booking.domain.Accommodation.PricingType PricingType;
    private int DaysForCancellation;
    private List<String> Amenities;
    private com.booking.domain.Accommodation.AccommodationStatus AccommodationStatus;
    private List<String> Images;
    private AccommodationType Type;
    private ConfirmationMethod ConfirmationMethod;
    private Long OwnerID;
}
