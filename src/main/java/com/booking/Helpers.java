package com.booking;

import com.booking.domain.Accommodation.AccommodationFreeSlot;
import com.booking.domain.DateRange;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static boolean isAccommodationFreeInAnyPeriod(List<AccommodationFreeSlot> slots, LocalDate start, LocalDate end) {
        for (AccommodationFreeSlot slot : slots) if (Helpers.isAccommodationFreeInSlot(slot, start ,end)) return true;
        return false;
    }

    public static boolean isAccommodationFreeInSlot(AccommodationFreeSlot slot, LocalDate start, LocalDate end) {
        return (slot.getStartDate().isBefore(start) || slot.getStartDate().isEqual(start)) &&
                (slot.getEndDate().isAfter(end) || slot.getEndDate().isEqual(end));
    }

    public static List<DateRange> useUpASlot(AccommodationFreeSlot slot, LocalDate start, LocalDate end) {
        LocalDate startSlot = slot.getStartDate();
        LocalDate endSlot = slot.getEndDate();
        if (start.equals(startSlot) && end.equals(endSlot)) return new ArrayList<>();
        ArrayList<DateRange> newSlots = new ArrayList<>();

        // from the end of the reservation to the end of the slot
        DateRange after = new DateRange();
        after.setStartDate(end);
        after.setEndDate(endSlot);

        // from the start of the slot to the start of the reservation
        DateRange before = new DateRange();
        before.setStartDate(startSlot);
        before.setEndDate(start);

        if (startSlot.equals(start)) newSlots.add(after);
        else if (endSlot.equals(end)) newSlots.add(before);
        else {
            newSlots.add(before);
            newSlots.add(after);
        }

        return newSlots;
    }
}
