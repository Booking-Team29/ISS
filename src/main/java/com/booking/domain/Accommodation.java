package com.booking.domain;

import com.booking.dto.ApproveAccommodationDTO;
import com.booking.dto.ChangeAccommodationDTO;
import com.booking.dto.CreateAccommodationDTO;
import lombok.*;
import org.hibernate.annotations.Where;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "accommodation")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "locationcoordinates")
    @ElementCollection
    private List<Float> locationCoordinates;

    @Column(name = "minguests")
    private int minGuests;
    @Column(name = "maxguests")
    private int maxGuests;

    @Column(name = "prices")
    @ElementCollection
    private List<Price> prices;
    @Column(name = "pricingtype")
    private PricingType pricingType;
    @Column(name = "daysforcancellation")
    private int daysForCancellation;
    @Column(name = "amenities")
    @ElementCollection
    private List<String> amenities;
    @Column(name = "status")
    private AccommodationStatus accommodationStatus;
    @Column(name = "images")
    @ElementCollection
    private List<String> images;
    @Column(name = "type")
    private AccommodationType type;
    @Column(name = "availabledates")
    @ElementCollection
    private List<Date> availableDates;

    public Accommodation(Long ID, String name, String description, String location, List<Float> locationCoordinates, int minGuests, int maxGuests, List<Price> prices, com.booking.domain.PricingType pricingType, int daysForCancellation, List<String> amenities, com.booking.domain.AccommodationStatus accommodationStatus, List<String> images, AccommodationType type, List<Date> availableDates) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.location = location;
        this.locationCoordinates = locationCoordinates;
        this.minGuests = minGuests;
        this.maxGuests = maxGuests;
        this.prices = prices;
        this.pricingType = pricingType;
        this.daysForCancellation = daysForCancellation;
        this.amenities = amenities;
        this.accommodationStatus = accommodationStatus;
        this.images = images;
        this.type = type;
        this.availableDates = availableDates;
    }

    // Static factory method
    public static Accommodation fromCreateDTO(CreateAccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setLocation(dto.getLocation());
        accommodation.setLocationCoordinates(List.of(dto.getLocationCoordinates()));
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(List.of(dto.getPrices()));
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(List.of(dto.getAmenities()));
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(List.of(dto.getImages()));
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(List.of(dto.getAvaliableDates()));
        return accommodation;
    }


    // Static factory method
    public static Accommodation fromApproveDTO(ApproveAccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setID(dto.getID());
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setLocation(dto.getLocation());
        accommodation.setLocationCoordinates(List.of(dto.getLocationCoordinates()));
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(List.of(dto.getPrices()));
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(List.of(dto.getAmenities()));
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(List.of(dto.getImages()));
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(List.of(dto.getAvaliableDates()));
        return accommodation;
    }

    public static Accommodation fromChangeDTO(ChangeAccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setID(dto.getID());
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setLocation(dto.getLocation());
        accommodation.setLocationCoordinates(List.of(dto.getLocationCoordinates()));
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(List.of(dto.getPrices()));
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(List.of(dto.getAmenities()));
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(List.of(dto.getImages()));
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(List.of(dto.getAvaliableDates()));
        return accommodation;
    }
}
