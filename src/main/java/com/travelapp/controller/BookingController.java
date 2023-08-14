package com.travelapp.controller;

import com.travelapp.dto.BookingDTO;
import com.travelapp.entity.Booking;
import com.travelapp.form.BookingFilterForm;
import com.travelapp.form.BookingUpdateForm;
import com.travelapp.service.interfaceService.IBookingService;
import com.travelapp.validation.anotation.BookingExistsById;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/bookings")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private ModelMapper mapper;

//    @GetMapping
//    public Page<BookingDTO> findAllBookings(Pageable pageable, BookingFilterForm form) {
//        Page<Booking> page = bookingService.findAllBookings(pageable, form);
//        List<BookingDTO> dtos = mapper.map(
//                page.getContent(),
//                new TypeToken<List<BookingDTO>>() {
//                }.getType()
//        );
//        return new PageImpl<>(dtos, pageable, page.getTotalElements());
//    }

    @GetMapping("from/{bookingStart}/to/{bookingEnd}")
    public List<Booking> getByBookingDateBetween(@PathVariable LocalDateTime bookingStart, LocalDateTime bookingEnd) {
        return bookingService.findByBookingDateBetween(bookingStart,bookingEnd);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        Booking booking = bookingService.findBookingById(bookingId);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-status/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable Booking.BookingStatus bookingStatus) {
        return bookingService.findBookingByStatus(bookingStatus);
    }

    @GetMapping("/by-userId/{userId}")
    public List<Booking> getBookingByUserId(@PathVariable Integer userId) {
        return bookingService.findByUserId(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PutMapping("/{bookingId}")
//    public void updateBooking(@PathVariable("id") @BookingExistsById Integer bookingId, @RequestBody @Valid BookingUpdateForm bookingUpdateForm) {
//        bookingUpdateForm.setBookingId(bookingId);
//        bookingService.updateBooking(bookingUpdateForm);
//    }

    @DeleteMapping("/{bookingId}")
    public void deleteById(@PathVariable("id") @BookingExistsById Integer bookingId) {
        bookingService.deleteBooking(bookingId);
    }

}
