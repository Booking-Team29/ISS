package com.booking.controller;

import com.booking.domain.User;
import com.booking.dto.*;
import com.booking.security.TokenUtils;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;
    @Autowired
    public AccountController(UserService userService, AuthenticationManager authenticationManager, TokenUtils tokenUtils) {
        this.userService = userService;
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping(
            path = "/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('Guest', 'Owner', 'Admin')")
    public ResponseEntity<UserDTO> getByEmail(@RequestParam() String email) {
        User acc = userService.findByEmail(email);
        UserDTO accDto = new UserDTO();
        accDto.FromUser(acc);
        return new ResponseEntity<>(accDto, HttpStatus.OK);
    }

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
    @PreAuthorize("hasAnyAuthority('Guest', 'Owner', 'Admin')")
    public ResponseEntity<ChangeUserDataDTO> changeUserData(@RequestBody ChangeUserDataDTO userChangeData,
                                                                      @PathVariable int id) {
        //IMPLEMENT SERVICE
        return new ResponseEntity<>(userChangeData, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/{id}"
    )
    @PreAuthorize("hasAnyAuthority('Guest', 'Owner', 'Admin')")
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
            path = "/financialReport/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('Guest', 'Owner', 'Admin')")
    public ResponseEntity<FinancialReportDTO> getFinancialReport() {
        // implement service

        FinancialReportDTO report = new FinancialReportDTO();

        return new ResponseEntity<>(report, HttpStatus.OK);
    }
}
