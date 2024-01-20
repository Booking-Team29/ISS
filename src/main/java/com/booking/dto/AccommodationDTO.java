package com.booking.dto;

import com.booking.domain.Accommodation;
import com.booking.domain.AccommodationType;
import com.booking.domain.DateRange;
import com.booking.domain.Price;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class AccommodationDTO {

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
    private List<DateRange> AvaliableDates;

    public static AccommodationDTO fromAccommodation(Accommodation acc) {
        AccommodationDTO dto = new AccommodationDTO();
        dto.setID(acc.getID());
        dto.setName(acc.getName());
        dto.setDescription(acc.getDescription());
        dto.setLocation(acc.getLocation());
        dto.setLocationCoordinates(acc.getLocationCoordinates());
        dto.setMinGuests(acc.getMinGuests());
        dto.setMaxGuests(acc.getMaxGuests());
        dto.setPrices(acc.getPrices());
        dto.setPricingType(acc.getPricingType());
        dto.setDaysForCancellation(acc.getDaysForCancellation());
        dto.setAmenities(acc.getAmenities());
        dto.setAccommodationStatus(acc.getAccommodationStatus());
        dto.setImages(acc.getImages());
        dto.setType(acc.getType());
        dto.setAvaliableDates(acc.getAvailableDates());
        return dto;
    }

}
