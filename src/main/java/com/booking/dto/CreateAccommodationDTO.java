package com.booking.dto;

import com.booking.domain.AccommodationStatus;
import com.booking.domain.AccommodationType;
import com.booking.domain.Price;
import com.booking.domain.PricingType;
import lombok.*;

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
    private Float[] LocationCoordinates;
    private int MinGuests;
    private int MaxGuests;
    private Price[] prices;
    private com.booking.domain.PricingType PricingType;
    private int DaysForCancellation;
    private String[] Amenities;
    private com.booking.domain.AccommodationStatus AccommodationStatus;
    private String[] Images;
    private AccommodationType Type;
    private Date[] AvaliableDates;

}
