package com.booking.domain.Accommodation;

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

    @Column(name = "accommodationid")
    private Long accommodationId;
}
