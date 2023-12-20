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
    private List<Float> locationCoordinates;

    @Column(name = "minguests")
    private int minGuests;
    @Column(name = "maxguests")
    private int maxGuests;

    @OneToMany(
            mappedBy = "accommodation",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Price> prices;

    @Column(name = "pricingtype")
    @Enumerated(EnumType.STRING)
    private PricingType pricingType;

    @Column(name = "daysforcancellation")
    private int daysForCancellation;

    @Column(name = "amenities")
    private List<String> amenities;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccommodationStatus accommodationStatus;

    @Column(name = "images")
    private List<String> images;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccommodationType type;

    @Column(name = "availabledates")
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
        accommodation.setLocationCoordinates(dto.getLocationCoordinates());
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(dto.getPrices());
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(dto.getAvaliableDates());
        return accommodation;
    }


    // Static factory method
    public static Accommodation fromApproveDTO(ApproveAccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setID(dto.getID());
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setLocation(dto.getLocation());
        accommodation.setLocationCoordinates(dto.getLocationCoordinates());
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(dto.getPrices());
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(dto.getAvaliableDates());
        return accommodation;
    }

    public static Accommodation fromChangeDTO(ChangeAccommodationDTO dto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setID(dto.getID());
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setLocation(dto.getLocation());
        accommodation.setLocationCoordinates(dto.getLocationCoordinates());
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        accommodation.setPrices(dto.getPrices());
        accommodation.setPricingType(dto.getPricingType());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
        accommodation.setAvailableDates(dto.getAvaliableDates());
        return accommodation;
    }
}
