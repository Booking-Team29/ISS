package com.booking.controller;

import com.booking.domain.User.Account;
import com.booking.domain.User.UserStatus;
import com.booking.dto.FinancialReportDTO;
import com.booking.dto.User.*;
import com.booking.security.TokenUtils;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PreAuthorize("hasAnyAuthority('GUEST', 'OWNER', 'ADMIN')")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable String email) {
        Optional<Account> acc = userService.findByEmail(email);
        if (acc.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        UserDTO accDto = new UserDTO();
        accDto.FromUser(acc.get());
        return new ResponseEntity<>(accDto, HttpStatus.OK);
    }

    @PostMapping(
            path = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginData) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginData.getUsername(),
                        loginData.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Account account = (Account) authentication.getPrincipal();
        if (account.getUserStatus() != UserStatus.ACTIVATED) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        String jwt = tokenUtils.generateToken(account);
        Long valid_for = tokenUtils.getExpiration();
        TokenDTO token = new TokenDTO(jwt, valid_for);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping(
            path = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO registerData) {
        Optional<Account> acc = userService.findByEmail(registerData.getEmailAddress());
        if (!acc.isEmpty()) throw new RuntimeException("Email already exists");
        Account new_acc = new Account();
        new_acc.fromRegisterDTO(registerData);
        new_acc.setUserStatus(UserStatus.ACTIVATED);
        userService.save(new_acc);
        return new ResponseEntity<>(registerData, HttpStatus.CREATED);
    }

//    @PutMapping(
//            path = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    @PreAuthorize("hasAnyAuthority('GUEST', 'OWNER', 'ADMIN')")
//    public ResponseEntity<Account> changeUserData(@RequestBody ChangeUserDataDTO userChangeData,
//                                                            @PathVariable Long id) {
//        Optional<Account> acc = userService.findById(id);
//        if (acc.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        Account me = acc.get();
//
//        if (!userChangeData.getFirstName().isEmpty()) {
//            me.setFirstName(userChangeData.getFirstName());
//        }
//
//        if (!userChangeData.getLastName().isEmpty()) {
//            me.setLastName(userChangeData.getLastName());
//        }
//
//        if (!userChangeData.getEmail().isEmpty()) {
//            Optional<Account> existing = userService.findByEmail(userChangeData.getEmail());
//            if (!existing.isEmpty()) {
//                Account x = existing.get();
//                if (!x.getUserId().equals(me.getUserId())) {
//                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//                }
//            }
//
//            me.setEmailAddress(userChangeData.getEmail());
//        }
//
//        if (!userChangeData.getPassword().isEmpty()) {
//            me.setHashedPassword(userChangeData.getPassword());
//        }
//
//        if (!userChangeData.getAddress().isEmpty()) {
//            me.setHomeAddress(userChangeData.getAddress());
//        }
//
//        if (userChangeData.getPhone() != 0) {
//            me.setHomeAddress(userChangeData.getAddress());
//        }
//
//
//        userService.save(me);
//        return new ResponseEntity<>(userChangeData, HttpStatus.OK);
//    }

    @DeleteMapping(
            path = "/delete/{id}"
    )
    @PreAuthorize("hasAnyAuthority('GUEST', 'OWNER', 'ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userService.delete(id);
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
    @PreAuthorize("hasAnyAuthority('Admin')")
    public ResponseEntity<FinancialReportDTO> getFinancialReport() {
        // implement service

        FinancialReportDTO report = new FinancialReportDTO();

        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    // the following method is used to block a user
    @PostMapping(
            path = "/block/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ChangeUserDataDTO> blockUser(@PathVariable Long userId) {
        userService.blockUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Account acc = userService.findById(id);
        UserDTO accDto = new UserDTO();
        accDto.FromUser(acc);
        return new ResponseEntity<>(accDto, HttpStatus.OK);
    }
}
