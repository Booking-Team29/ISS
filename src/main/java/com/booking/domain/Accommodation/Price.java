package com.booking.domain.Accommodation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private String Type;

    @Column(name = "amount")
    private double amount;

    @Column(name = "startdate")
    private LocalDate start;

    @Column(name = "enddate")
    private LocalDate end;

//    @ManyToOne(
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(name = "accommodationid")
//    @JsonIgnore // avoid infinite recursion (dont serialize ?)
//    private Accommodation accommodation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodationid", insertable = false, updatable = false)
    @JsonIgnore
    private Accommodation accommodation;

    @Column(name = "accommodationid")
    private Long accommodationId;

    public Price(String type, double amount, LocalDate start, LocalDate end, Long accommodationId) {
        Type = type;
        this.amount = amount;
        this.start = start;
        this.end = end;
        this.accommodationId = accommodationId;
    }
}
