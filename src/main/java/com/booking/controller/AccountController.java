package com.booking.controller;

import com.booking.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @PostMapping(
            path = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> login(@RequestBody LoginDTO loginData) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(loginData, HttpStatus.OK);
    }

    @PostMapping(
            path = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerData) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(registerData, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ChangeUserDataDTO> changeUserData(@RequestBody ChangeUserDataDTO userChangeData,
                                                                      @PathVariable int id) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(userChangeData, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/{id}"
    )
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(
            path = "/confirmEmail",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ConfirmEmailDTO> confirmEmail(@RequestBody ConfirmEmailDTO emailConfirmation) {
        // implement service

        return new ResponseEntity<>(emailConfirmation, HttpStatus.OK);
    }

    @GetMapping(
            path = "/financialReport",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FinancialReportDTO> getFinancialReport() {
        // implement service

        FinancialReportDTO report = new FinancialReportDTO();

        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
