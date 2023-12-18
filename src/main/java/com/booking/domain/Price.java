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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "type")
    private PriceType Type;

    @Column(name = "price")
    private double price;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    public Price(PriceType type, double price, Date start, Date end) {
        Type = type;
        this.price = price;
        this.start = start;
        this.end = end;
    }
}
