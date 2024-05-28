package com.booking.domain.Accommodation;

import com.booking.dto.Accommodation.ApproveAccommodationDTO;
import com.booking.dto.Accommodation.ChangeAccommodationDTO;
import com.booking.dto.Accommodation.CreateAccommodationDTO;
import lombok.*;

//import javax.persistence.*;
import jakarta.persistence.*;

import java.time.LocalDate;
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
    @Column(name = "id")
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
    private String pricingType;

    @Column(name = "daysforcancellation")
    private int daysForCancellation;

    @Column(name = "amenities")
    private List<String> amenities;

    @Column(name = "status")
    //@Enumerated(EnumType.STRING)
    private AccommodationStatus accommodationStatus;

    @Column(name = "images")
    private List<String> images;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccommodationType type;

    @Column(name = "confirmationmethod")
    @Enumerated(EnumType.STRING)
    private ConfirmationMethod confirmationMethod;

    @Column(name = "ownerid")
    private Long ownerId;

    public Accommodation(Long ID, String name, String description, String location, List<Float> locationCoordinates, int minGuests, int maxGuests, List<Price> prices, String pricingType, int daysForCancellation, List<String> amenities, AccommodationStatus accommodationStatus, List<String> images, AccommodationType type, ConfirmationMethod confirmationMethod) {
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
        this.confirmationMethod = confirmationMethod;
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
        accommodation.setPricingType(dto.getPricingType().toString());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
        accommodation.setConfirmationMethod(dto.getConfirmationMethod());
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
        accommodation.setPricingType(dto.getPricingType().toString());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
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
        accommodation.setPricingType(dto.getPricingType().toString());
        accommodation.setDaysForCancellation(dto.getDaysForCancellation());
        accommodation.setAmenities(dto.getAmenities());
        accommodation.setAccommodationStatus(dto.getAccommodationStatus());
        accommodation.setImages(dto.getImages());
        accommodation.setType(dto.getType());
        accommodation.setConfirmationMethod(dto.getConfirmationMethod());
        return accommodation;
    }
}
