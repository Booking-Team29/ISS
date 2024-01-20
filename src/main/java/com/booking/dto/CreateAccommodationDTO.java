package com.booking.dto;

import com.booking.domain.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class CreateAccommodationDTO {

    private String Name;
    private String Description;
    private String Location;
    private List<Float> LocationCoordinates;
    private int MinGuests;
    private int MaxGuests;
    private List<Price> prices;
    private com.booking.domain.PricingType PricingType;
    private int DaysForCancellation;
    private List<String> Amenities;
    private com.booking.domain.AccommodationStatus AccommodationStatus;
    private List<String> Images;
    private AccommodationType Type;
    private List<DateRange> AvaliableDates;
    private ConfirmationMethod confirmationMethod;

}
