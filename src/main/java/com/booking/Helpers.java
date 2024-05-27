package com.booking;

import com.booking.domain.Accommodation.AccommodationFreeSlot;

import java.time.LocalDate;
import java.util.List;

public class Helpers {

    public static boolean isAccommodationFreeInPeriod(List<AccommodationFreeSlot> slots, LocalDate start, LocalDate end) {
        for (AccommodationFreeSlot slot : slots) {
            if (
                    (slot.getStartDate().isBefore(start) || slot.getStartDate().isEqual(start)) &&
                    (slot.getEndDate().isAfter(end) || slot.getEndDate().isEqual(end))
            ) return true;
        }
        return false;
    }
}
