package com.booking.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "Favorite")
@Getter
@Setter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "AccommodationId", referencedColumnName = "id")
    private Accommodation accommodation;

}