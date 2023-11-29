package com.booking.dto;

import com.booking.domain.AccommodationStatus;
import com.booking.domain.AccommodationType;
import com.booking.domain.Price;
import lombok.*;

import java.util.Date;
@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class ApproveAccommodationDTO {

    private String Name;
    private String Description;
    private String Location;
    private int[] LocationCoordinates;
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
