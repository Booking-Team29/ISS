package com.booking.dto;

import com.booking.domain.AccommodationStatus;
import com.booking.domain.AccommodationType;
import com.booking.domain.DateRange;
import com.booking.domain.Price;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import java.util.Date;
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
    private com.booking.domain.PricingType PricingType;
    private int DaysForCancellation;
    private List<String> Amenities;
    private com.booking.domain.AccommodationStatus AccommodationStatus;
    private List<String> Images;
    private AccommodationType Type;
    private List<List<LocalDate>> AvaliableDates;
}
