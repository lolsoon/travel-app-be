package com.travelapp.service.interfaceService;

import com.travelapp.dto.BookingDTO;
import com.travelapp.entity.Booking;
import com.travelapp.entity.User;
import com.travelapp.form.BookingFilterForm;
import com.travelapp.form.BookingUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookingService {
    List<Booking> findByBookingDateBetween(LocalDateTime bookingStart, LocalDateTime bookingEnd);

//    Page<Booking> findAllBookings(Pageable pageable, BookingFilterForm filterForm);
    Booking findBookingById(int bookingId);

    List<Booking> findByUserId(Integer userId);

//    List<Booking> findByTourId(Integer tourId);
//
//    List<Booking> findByFlightId(Integer flightId);
//
//    List<Booking> findByHotelId(Integer hotelId);

    List<Booking> findBookingByStatus(Booking.BookingStatus bookingStatus);

    void createBooking(Booking booking);

//    void updateBooking(BookingUpdateForm bookingUpdateForm);

    void deleteBooking(Integer bookingId);
}
