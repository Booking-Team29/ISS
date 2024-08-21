package com.booking.domain.Accommodation;

import com.booking.domain.User.Account;
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
    @Column(name = "favoriteid")
    private Long favoriteId;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "accommodationid", referencedColumnName = "id")
    private Accommodation accommodation;

}
