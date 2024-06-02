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
import com.booking.dto.Accommodation.GetAccommodationDTO;
import com.booking.dto.Reservation.ReservationDTO;
import com.booking.dto.Reservation.ReservationRequestDTO;
import com.booking.repository.AccommodationFreeSlotRepository;
import com.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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
    public ReservationController(ReservationService service, AccommodationService accommodationService, AccommodationFreeSlotService accommodationFreeSlotService, ReservationRequestService reservationRequestService, UserService userService, ReservationServiceImpl reservationServiceImpl, AccommodationFreeSlotRepository accommodationFreeSlotRepository) {
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
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<Collection<Reservation>> getReservations() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();
        List<Reservation> reservations = this._reservationService.findReservationByUserId(acc.getUserId());
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/reservationRequests"
    )
    @PreAuthorize("hasAnyAuthority('OWNER', 'GUEST')")
    public ResponseEntity<Collection<ReservationRequest>> getReservationCreationRequests() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();
        String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().get());

        if (role.equals("OWNER"))  {
            Collection<Accommodation> accommodations = accommodationService.findAccommodationByUserId(acc.getUserId());
            Collection<ReservationRequest> res = new ArrayList<>();
            for (Accommodation accommodation : accommodations)
                res.addAll(reservationRequestService.findAllForAccommodation(accommodation.getID()));
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            // guest
            Collection<ReservationRequest> res = reservationRequestService.findAllForuser(acc.getUserId());
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<ReservationRequest> createReservationRequest(@RequestBody ReservationRequestDTO reservation) {
        reservation.setId(null);

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

        ReservationRequest res = ReservationRequest.fromReservationRequestDTO(reservation, acc.getUserId());
        res.setStatus(ReservationStatus.REQUESTED);

        // approve reservation if its automatic
        if (accommodation.getConfirmationMethod() == ConfirmationMethod.AUTOMATIC) {
            res.setStatus(ReservationStatus.APPROVED);
            this.reservationRequestService.denyAllRequestsForASlot(slot.getID());

            ReservationRequest resRequest = ReservationRequest.fromReservationRequestDTO(reservation, acc.getUserId());
            Reservation resClass = Reservation.fromReservationRequest(resRequest);
            ReservationDTO reservationDTO = ReservationDTO.fromReservation(resClass);
            reservationDTO.setStatus(ReservationStatus.APPROVED);
            _reservationService.saveReservation(reservationDTO);

            List<DateRange> newSlots = Helpers.useUpASlot(slot, reservation.getStartDate(), reservation.getEndDate());
            for(DateRange range : newSlots) {
                AccommodationFreeSlot newSlot = new AccommodationFreeSlot();
                newSlot.setAccommodationId(reservation.getAccommodationId());
                newSlot.setStartDate(range.getStartDate());
                newSlot.setEndDate(range.getEndDate());
                newSlot.setAvailable(true);
                accommodationFreeSlotService.saveAccommodationFreeSlot(newSlot);
            }
            this.accommodationFreeSlotService.disableSlot(reservation.getSlotId());
        }

        return new ResponseEntity<>(reservationRequestService.save(res), HttpStatus.CREATED);
    }

    @DeleteMapping(
            path = "/{reservationId}"
    )
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<ReservationDTO> cancelReservation(@PathVariable Long reservationId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();
        Reservation reservation = this._reservationService.findOne(reservationId);
        Accommodation accommodation = this.accommodationService.findOne(reservation.getAccommodationId());

        if (reservation.getUserId() != acc.getUserId()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (reservation.getStatus() != ReservationStatus.APPROVED) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        LocalDate lastDayToCancel = reservation.getStartDate().minusDays(accommodation.getDaysForCancellation());
        LocalDate today = LocalDate.now();
        if(lastDayToCancel.isBefore(today)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this._reservationService.markReservationCancelled(reservationId);

        AccommodationFreeSlot slot = new AccommodationFreeSlot();
        slot.setAvailable(true);
        slot.setID(-1L);
        slot.setStartDate(reservation.getStartDate());
        slot.setEndDate(reservation.getEndDate());
        slot.setAccommodationId(reservation.getAccommodationId());

        this.accommodationFreeSlotService.saveAccommodationFreeSlot(slot);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/reservationRequests/delete/{reservationRequestId}"
    )
    @PreAuthorize("hasAnyAuthority('GUEST')")
    public ResponseEntity<Void> deleteReservationRequest(@PathVariable Long reservationRequestId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();

        Optional<ReservationRequest> requestOptional = reservationRequestService.findById(reservationRequestId);
        if (requestOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReservationRequest request = requestOptional.get();
        if (request.getStatus() != ReservationStatus.REQUESTED) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (request.getUserId() != acc.getUserId()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.reservationRequestService.markRequestDeleted(reservationRequestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(
            path = "/reservationRequests/deny/{reservationRequestId}"
    )
    @PreAuthorize("hasAnyAuthority('OWNER')")
    public ResponseEntity<Void> denyReservationRequest(@PathVariable Long reservationRequestId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();

        Optional<ReservationRequest> requestOptional = reservationRequestService.findById(reservationRequestId);
        if (requestOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReservationRequest request = requestOptional.get();
        if (request.getStatus() != ReservationStatus.REQUESTED) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Accommodation accommodation = this.accommodationService.findOne(request.getAccommodationId());
        if (accommodation.getOwnerId() != acc.getUserId()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.reservationRequestService.markRequestDenied(reservationRequestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(
            value = "/reservationRequests/approve/{reservationRequestId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasAnyAuthority('OWNER')")
    public ResponseEntity<Void> approveReservationRequest(@PathVariable Long reservationRequestId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Account acc = userService.findByEmail(email).get();

        Optional<ReservationRequest> requestOptional = reservationRequestService.findById(reservationRequestId);
        if (requestOptional.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReservationRequest request = requestOptional.get();
        if (request.getStatus() != ReservationStatus.REQUESTED) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Accommodation accommodation = this.accommodationService.findOne(request.getAccommodationId());
        if (accommodation.getOwnerId() != acc.getUserId()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // deny all overlapping requests
        this.reservationRequestService.denyAllRequestsForASlot(request.getSlotId());

        this.reservationRequestService.markRequestApproved(reservationRequestId);

        // create the reservation
        Reservation reservation = Reservation.fromReservationRequest(request);
        reservation.setStatus(ReservationStatus.APPROVED);
        ReservationDTO reservationDTO = ReservationDTO.fromReservation(reservation);
        this._reservationService.saveReservation(reservationDTO);

        // create new slot if necessary
        Optional<AccommodationFreeSlot> optionaLSlot = accommodationFreeSlotService.findOne(request.getSlotId());
        if (optionaLSlot.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        AccommodationFreeSlot slot = optionaLSlot.get();

        List<DateRange> newSlots = Helpers.useUpASlot(slot, reservation.getStartDate(), reservation.getEndDate());
        for(DateRange range : newSlots) {
            AccommodationFreeSlot newSlot = new AccommodationFreeSlot();
            newSlot.setAccommodationId(reservation.getAccommodationId());
            newSlot.setStartDate(range.getStartDate());
            newSlot.setEndDate(range.getEndDate());
            newSlot.setAvailable(true);
            accommodationFreeSlotService.saveAccommodationFreeSlot(newSlot);
        }

        this.accommodationFreeSlotService.disableSlot(request.getSlotId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}