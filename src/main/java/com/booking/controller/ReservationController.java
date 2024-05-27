package com.booking.controller;

import com.booking.Helpers;
import com.booking.domain.Accommodation.Accommodation;
import com.booking.domain.Accommodation.AccommodationFreeSlot;
import com.booking.domain.Accommodation.ConfirmationMethod;
import com.booking.domain.DateRange;
import com.booking.domain.Reservation.Reservation;
import com.booking.domain.Reservation.ReservationRequest;
import com.booking.domain.Reservation.ReservationStatus;
import com.booking.domain.User.Account;
import com.booking.dto.Reservation.ReservationDTO;
import com.booking.dto.Reservation.ReservationRequestDTO;
import com.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT},
        allowedHeaders = "*"
)
public class ReservationController {
    private final ReservationServiceImpl reservationServiceImpl;
    private ReservationService _reservationService;
    private AccommodationService accommodationService;
    private AccommodationFreeSlotService accommodationFreeSlotService;
    private ReservationRequestService reservationRequestService;
    private UserService userService;


    @Autowired
    public ReservationController(ReservationService service, AccommodationService accommodationService, AccommodationFreeSlotService accommodationFreeSlotService, ReservationRequestService reservationRequestService, UserService userService, ReservationServiceImpl reservationServiceImpl) {
        this._reservationService = service;
        this.accommodationService = accommodationService;
        this.accommodationFreeSlotService = accommodationFreeSlotService;
        this.reservationRequestService = reservationRequestService;
        this.userService = userService;
        this.reservationServiceImpl = reservationServiceImpl;
    }


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservationRequests() {
        List<ReservationDTO> reservations = this._reservationService.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationRequest> createReservationRequest(@RequestBody ReservationRequestDTO reservation) {
        reservation.setId(null);

        reservation.setStatus(ReservationStatus.REQUESTED);
        Accommodation accommodation = accommodationService.findOne(reservation.getAccommodationId());

        if (reservation.getGuestsCount() > accommodation.getMaxGuests() || reservation.getGuestsCount() < accommodation.getMinGuests())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<AccommodationFreeSlot> optionaLSlot = accommodationFreeSlotService.findOne(reservation.getSlotId());
        if (optionaLSlot.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        AccommodationFreeSlot slot = optionaLSlot.get();
        if(!Helpers.isAccommodationFreeInSlot(slot, reservation.getStartDate(), reservation.getEndDate()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (slot.getAccommodationId() != reservation.getAccommodationId())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<Account> accOptional = userService.findByEmail(reservation.getUserEmail());
        if (accOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Account acc = accOptional.get();

        // approve reservation if its automatic
        if (accommodation.getConfirmationMethod() == ConfirmationMethod.AUTOMATIC) {
            List<DateRange> newSlots = Helpers.useUpASlot(slot, reservation.getStartDate(), reservation.getEndDate());
            accommodationFreeSlotService.deleteAccommodationFreeSlot(slot);
            for(DateRange range : newSlots) {
                AccommodationFreeSlot newSlot = new AccommodationFreeSlot();
                newSlot.setAccommodationId(reservation.getAccommodationId());
                newSlot.setStartDate(range.getStartDate());
                newSlot.setEndDate(range.getEndDate());
                accommodationFreeSlotService.saveAccommodationFreeSlot(newSlot);
            }
            reservation.setStatus(ReservationStatus.APPROVED);

            ReservationRequest resRequest = ReservationRequest.fromReservationRequestDTO(reservation, acc.getUserId());
            Reservation resClass = Reservation.fromReservationRequest(resRequest);
            ReservationDTO res = ReservationDTO.fromReservation(resClass);
            _reservationService.saveReservation(res);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            ReservationRequest res = ReservationRequest.fromReservationRequestDTO(reservation, acc.getUserId());
            return new ResponseEntity<>(reservationRequestService.save(res), HttpStatus.CREATED);
        }
    }

    @GetMapping(
            path = "/reservationRequests/{ownerId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservationRequests(@PathVariable Long ownerId) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @GetMapping(
            path = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<ReservationDTO>> getReservations(@PathVariable Long userId) {
         this._reservationService.findOne(userId);

        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }

    @PutMapping(
            path = "/{reservationId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/reservationRequest/{reservationId}"
    )
    public ResponseEntity<Void> deleteReservationRequest(@PathVariable Long reservationId) {
        ReservationDTO reservation = new ReservationDTO();
        if (reservation.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}