package com.booking.dto.Accommodation;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.domain.Accommodation.AccommodationType;
import com.booking.domain.Accommodation.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccommodationFilterDTO {
    private Long ID;
    private String Name;
    private String Description;
    private String Location;
    private List<Float> LocationCoordinates;
    private int MinGuests;
    private int MaxGuests;
    private List<Price> prices;
    private String PricingType;
    private int DaysForCancellation;
    private List<String> Amenities;
    private com.booking.domain.Accommodation.AccommodationStatus AccommodationStatus;
    private List<String> Images;
    private AccommodationType Type;
    private Double rating;
     public static AccommodationFilterDTO fromAccommodation(Accommodation acc, Double rating) {
        AccommodationFilterDTO dto = new AccommodationFilterDTO();
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
        dto.rating = rating;
        return dto;
    }
}
