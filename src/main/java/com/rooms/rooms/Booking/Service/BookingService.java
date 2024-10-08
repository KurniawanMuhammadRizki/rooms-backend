package com.rooms.rooms.Booking.Service;

import com.rooms.rooms.Booking.Entity.Booking;
import com.rooms.rooms.Booking.dto.CreateBookingDto;

import java.util.List;

public interface BookingService {
    List<Booking> getBookedPropertiesByPropertyID(Long propertyID);
    Booking createBooking(CreateBookingDto dto);
    Booking getBookingByTransactionDetailId(Long transactionDetailId);
    void deleteBookingById(Long id);
    List<Booking> getUpcomingBookingsByPropertyId(Long propertyId);
}
