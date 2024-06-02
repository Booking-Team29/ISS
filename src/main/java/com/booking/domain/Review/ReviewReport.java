package com.booking.domain.Review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Table(name = "reviewreport")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class ReviewReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportid")
    private Long ReportId;

    @Column(name = "reportdate")
    private LocalDate ReportDate;

    @Column(name = "description")
    private String Description;

    @Column(name = "type")
    private ReviewType Type;

    @Column(name = "reporterid")
    private Long ReporterId;

    @Column(name = "reviewid")
    private Long ReviewId;
}
