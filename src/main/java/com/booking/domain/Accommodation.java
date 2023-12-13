package com.booking.domain;

import java.util.Date;

public class Accommodation {
    private Long ID;
    private String Name;
    private String Description;
    private String Location;
    private int[] LocationCoordinates;
    private int MinGuests;
    private int MaxGuests;
    private Price[] prices;
    private PricingType PricingType;
    private int DaysForCancellation;
    private String[] Amenities;
    private AccommodationStatus AccommodationStatus;
    private String[] Images;
    private AccommodationType Type;
    private Date[] AvaiableDates;

    public Accommodation(long ID, String name, String description, String location, int[] locationCoordinates, int minGuests, int maxGuests, Price[] prices, com.booking.domain.PricingType pricingType, int daysForCancellation, String[] amenities, com.booking.domain.AccommodationStatus accommodationStatus, String[] images, AccommodationType type, Date[] avaiableDates) {
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

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int[] getLocationCoordinates() {
        return LocationCoordinates;
    }

    public void setLocationCoordinates(int[] locationCoordinates) {
        LocationCoordinates = locationCoordinates;
    }

    public int getMinGuests() {
        return MinGuests;
    }

    public void setMinGuests(int minGuests) {
        MinGuests = minGuests;
    }

    public int getMaxGuests() {
        return MaxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        MaxGuests = maxGuests;
    }

    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }

    public com.booking.domain.PricingType getPricingType() {
        return PricingType;
    }

    public void setPricingType(com.booking.domain.PricingType pricingType) {
        PricingType = pricingType;
    }

    public int getDaysForCancellation() {
        return DaysForCancellation;
    }

    public void setDaysForCancellation(int daysForCancellation) {
        DaysForCancellation = daysForCancellation;
    }

    public String[] getAmenities() {
        return Amenities;
    }

    public void setAmenities(String[] amenities) {
        Amenities = amenities;
    }

    public com.booking.domain.AccommodationStatus getAccommodationStatus() {
        return AccommodationStatus;
    }

    public void setAccommodationStatus(com.booking.domain.AccommodationStatus accommodationStatus) {
        AccommodationStatus = accommodationStatus;
    }

    public String[] getImages() {
        return Images;
    }

    public void setImages(String[] images) {
        Images = images;
    }

    public AccommodationType getType() {
        return Type;
    }

    public void setType(AccommodationType type) {
        Type = type;
    }

    public Date[] getAvaiableDates() {
        return AvaiableDates;
    }

    public void setAvaiableDates(Date[] avaiableDates) {
        AvaiableDates = avaiableDates;
    }
}
