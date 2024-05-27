package com.booking.dto.Accommodation;

import com.booking.domain.Accommodation.Accommodation;
import com.booking.domain.Accommodation.AccommodationFreeSlot;
import com.booking.domain.Accommodation.AccommodationType;
import com.booking.domain.Accommodation.Price;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Setter
@Getter
@Data
@EqualsAndHashCode
public class GetAccommodationDTO {

    private Long id;
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
    private List<AccommodationFreeSlot> slots;

    public static GetAccommodationDTO fromAccommodation(Accommodation accommodationDTO) {
        GetAccommodationDTO res = new GetAccommodationDTO();
        res.id = accommodationDTO.getID();
        res.Name = accommodationDTO.getName();
        res.Description = accommodationDTO.getDescription();
        res.Location = accommodationDTO.getLocation();
        res.LocationCoordinates = accommodationDTO.getLocationCoordinates();
        res.MinGuests = accommodationDTO.getMinGuests();
        res.MaxGuests = accommodationDTO.getMaxGuests();
        res.prices = accommodationDTO.getPrices();
        res.PricingType = accommodationDTO.getPricingType();
        res.DaysForCancellation = accommodationDTO.getDaysForCancellation();
        res.Amenities = accommodationDTO.getAmenities();
        res.AccommodationStatus = accommodationDTO.getAccommodationStatus();
        res.Images = accommodationDTO.getImages();
        res.Type = accommodationDTO.getType();
        return res;
    }

}
