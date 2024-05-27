package com.booking.controller;
import com.booking.domain.Review.Review;
import com.booking.domain.Review.ReviewReport;
import com.booking.domain.Review.ReviewType;
import com.booking.domain.User.Account;
import com.booking.dto.Review.*;
import com.booking.service.ReviewReportService;
import com.booking.service.ReviewService;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.booking.dto.Review.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private UserService userService;
    private ReviewService reviewService;
    private ReviewReportService reviewReportService;

    @Autowired
    public ReviewController(UserService userService, ReviewService reviewService, ReviewReportService reviewReportService) {
        this.userService = userService;
        this.reviewService = reviewService;
        this.reviewReportService = reviewReportService;
    }

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation"
    )
    public ResponseEntity<CreateAccommodationReviewDTO> createAccommodationReview(@RequestBody CreateAccommodationReviewDTO review) {
        // implement service

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation"
    )
    public ResponseEntity<List<RetrieveAccommodationReviewDTO>> getAccommodationReviews() {
        ArrayList<RetrieveAccommodationReviewDTO> reviews = new ArrayList<RetrieveAccommodationReviewDTO>() {}; // implement service
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/accommodation/{ownerId}"
    )
    public ResponseEntity<List<RetrieveAccommodationReviewDTO>> getAccommodationReviewsByOwnerId(@PathVariable Long ownerId) {
        List<RetrieveAccommodationReviewDTO> reviews = new ArrayList<>(); // implement service

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/owner"
    )
    public ResponseEntity<CreateOwnerReviewDTO> createOwnerReview(@RequestBody CreateOwnerReviewDTO review) {
        // implement service

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping (
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/owner/{ownerId}"
    )
    public ResponseEntity<List<RetrieveOwnerReviewDTO>> getOwnerReviewsById(@PathVariable Long ownerId) {
        List<RetrieveOwnerReviewDTO> reviews = new ArrayList<>(); // implement service

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/{reviewId}"
    )
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewReportService.deleteReferencingReviewId(reviewId);
        reviewService.deleteById(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/report/{reportId}"
    )
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> deleteReviewReport(@PathVariable Long reportId) {
        reviewReportService.deleteById(reportId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(
            path = "/report",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('GUEST', 'OWNER')")
    public ResponseEntity<Void> reportAReview(@RequestBody ReportReviewDTO report) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();

        System.out.println(acc.getUserId());

        Optional<Review> reviewOptional = reviewService.findById(report.getReviewId());
        if (reviewOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReviewReport rr = new ReviewReport();
        rr.setReportDate(LocalDate.now());
        rr.setType(ReviewType.ACCOMMODATION);
        rr.setReporterId(acc.getUserId());
        rr.setDescription(report.getDescription());
        rr.setReviewId(report.getReviewId());

        this.reviewReportService.save(rr);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(
            path = "/reports"
    )
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<AllReviewReportsDTO> getReviewReports() {
        AllReviewReportsDTO dto = new AllReviewReportsDTO();
        dto.setReports(reviewReportService.getAllReports());

        List<Review> reviews = new ArrayList<>();
        for (ReviewReport rr: dto.getReports()) {
            System.out.println(rr.getReviewId());
            reviews.add(reviewService.findById(rr.getReviewId()).get());
        }

        dto.setReviews(reviews);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(
            path = "/rating/{accommodationId}"
    )
    public ResponseEntity<RatingDTO> getRating(@PathVariable Long accommodationId) {
        Double rating = reviewService.accommodationRating(accommodationId).orElse(0d);
        return new ResponseEntity<>(new RatingDTO(rating), HttpStatus.OK);
    }
    @PostMapping(
            path = "/user/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CreateUserReviewDTO> createUserReview(@RequestBody CreateUserReviewDTO review, @PathVariable Long userId) {
        // implement service

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}

