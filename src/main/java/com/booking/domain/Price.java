package com.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "price")
@NoArgsConstructor
@Getter
@Setter
public class Price {
    @Id
    @Column(name = "priceid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PriceType Type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "startdate")
    private Date start;

    @Column(name = "enddate")
    private Date end;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "accommodationid")
    @JsonIgnore // avoid infinite recursion (dont serialize ?)
    private Accommodation accommodation;

    public Price(PriceType type, double amount, Date start, Date end, Accommodation accommodation) {
        Type = type;
        this.price = price;
        this.start = start;
        this.end = end;
    }
}
