package com.booking.domain;

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
@Where(clause = "is_deleted = false")
@Inheritance(strategy = InheritanceType.JOINED)
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "name")
    private String Name;
    @Column(name = "description")
    private String Description;
    @Column(name = "location")
    private String Location;

    @Column(name = "locationcoordinates")
    @ElementCollection
    private List<Float> LocationCoordinates;

    @Column(name = "minguests")
    private int MinGuests;
    @Column(name = "maxguests")
    private int MaxGuests;

    @Column(name = "prices")
    @ElementCollection
    private List<Integer> prices;
    @Column(name = "pricingtype")
    private PricingType PricingType;
    @Column(name = "daysfrocancellation")
    private int DaysForCancellation;
    @Column(name = "amenities")
    @ElementCollection
    private List<String> Amenities;
    @Column(name = "accommodationstatus")
    private AccommodationStatus AccommodationStatus;
    @Column(name = "images")
    @ElementCollection
    private List<String> Images;
    @Column(name = "type")
    private AccommodationType Type;
    @Column(name = "avaiabledates")
    @ElementCollection
    private List<Date> AvaiableDates;

    public Accommodation(Long ID, String name, String description, String location, List<Float> locationCoordinates, int minGuests, int maxGuests, List<Integer> prices, com.booking.domain.PricingType pricingType, int daysForCancellation, List<String> amenities, com.booking.domain.AccommodationStatus accommodationStatus, List<String> images, AccommodationType type, List<Date> avaiableDates) {
        this.ID = ID;
        Name = name;
        Description = description;
        Location = location;
        LocationCoordinates = locationCoordinates;
        MinGuests = minGuests;
        MaxGuests = maxGuests;
        this.prices = prices;
        PricingType = pricingType;
        DaysForCancellation = daysForCancellation;
        Amenities = amenities;
        AccommodationStatus = accommodationStatus;
        Images = images;
        Type = type;
        AvaiableDates = avaiableDates;
    }
}
