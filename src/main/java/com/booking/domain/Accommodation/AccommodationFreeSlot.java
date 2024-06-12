package com.booking.domain.Accommodation;

import com.booking.dto.Accommodation.AccommodationFreeSlotDTO;
import com.booking.dto.Accommodation.CreateAccommodationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "accommodationfreeslot")
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class AccommodationFreeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "startdate")
    private LocalDate startDate;

    @Column(name = "enddate")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodationid", insertable = false, updatable = false)
    @JsonIgnore
    private Accommodation accommodation;

    @Column(name = "accommodationid")
    private Long accommodationId;

    @Column(name = "available")
    private Boolean available;

    public static AccommodationFreeSlot fromCreateDTO(AccommodationFreeSlotDTO dto) {
        AccommodationFreeSlot accommodationFreeSlot = new AccommodationFreeSlot();
        accommodationFreeSlot.setStartDate(dto.getStartDate());
        accommodationFreeSlot.setEndDate(dto.getEndDate());
        accommodationFreeSlot.setAccommodationId(dto.getAccommodationId());
        accommodationFreeSlot.setAvailable(dto.getAvailable());
        return accommodationFreeSlot;
    }

}

