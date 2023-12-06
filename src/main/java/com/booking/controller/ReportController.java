package com.booking.controller;

import com.booking.dto.ReviewReportDTO;
import com.booking.dto.UserReportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @PostMapping(
            path = "/userReport",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserReportDTO> createUserReport(@RequestBody UserReportDTO userReportDTO) {
        if (userReportDTO.equals(null)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new UserReportDTO(), HttpStatus.OK);
    }

    @PutMapping(
            path = "/userReport/{reportId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserReportDTO> updateUserReport(@RequestBody UserReportDTO userReportDTO, @PathVariable Long reportId) {
        UserReportDTO report = new UserReportDTO();
        if (report.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userReportDTO, HttpStatus.OK);
    }

    @PostMapping(
            path = "/reviewReport",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReviewReportDTO> createReviewReport(@RequestBody ReviewReportDTO reviewReportDTO) {
        if (reviewReportDTO.equals(null)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new ReviewReportDTO(), HttpStatus.OK);
    }

    @PutMapping(
            path = "/reviewReport/{reportId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReviewReportDTO> updateReviewReport(@RequestBody ReviewReportDTO reviewReportDTO, @PathVariable Long reportId) {
        ReviewReportDTO report = new ReviewReportDTO();
        if (report.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping(
            path = "/userReport/{userReportId}",
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserReportDTO> getUserReport(@PathVariable Long userReportId) {
        UserReportDTO report = new UserReportDTO();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping(
            path = "/reviewReport/{reviewReportId}",
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReviewReportDTO> getReviewReport(@PathVariable Long reviewReportId) {
        ReviewReportDTO report = new ReviewReportDTO();
        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
