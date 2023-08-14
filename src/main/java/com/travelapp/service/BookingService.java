package com.travelapp.service;

import com.travelapp.entity.Booking;
import com.travelapp.entity.User;
import com.travelapp.form.BookingFilterForm;
import com.travelapp.form.BookingUpdateForm;
import com.travelapp.repository.IBookingRepository;
import com.travelapp.service.interfaceService.IBookingService;
import com.travelapp.specification.BookingSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private TourService tourService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Booking> findByBookingDateBetween(LocalDateTime bookingStart, LocalDateTime bookingEnd) {
        return bookingRepository.findByBookingDateBetween(bookingStart, bookingEnd);
    }

//    @Override
//    public Page<Booking> findAllBookings(Pageable pageable, BookingFilterForm filterForm) {
//        return bookingRepository.findAllBookings(BookingSpecification.filterBookings(filterForm), pageable);
//    }

    @Override
    public Booking findBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public List<Booking> findByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

//    @Override
//    public List<Booking> findByTourId(Integer tourId) {
//        return bookingRepository.findByTourId(tourId);
//    }
//
//    @Override
//    public List<Booking> findByFlightId(Integer flightId) {
//        return bookingRepository.findByFlightId(flightId);
//    }
//
//    @Override
//    public List<Booking> findByHotelId(Integer hotelId) {
//        return bookingRepository.findByHotelId(hotelId);
//    }

    @Override
    public List<Booking> findBookingByStatus(Booking.BookingStatus bookingStatus) {
        return bookingRepository.findBookingByStatus(bookingStatus);
    }


    @Override
    public void createBooking(Booking booking) {
        // Kiểm tra xem thông tin khách hàng đã đủ chưa
        if (!isCustomerInfoComplete(booking.getUser())) {
            throw new IllegalArgumentException("Thông tin của khách hàng chưa đầy đủ");
        }
        bookingRepository.save(booking);
    }

    // Kiểm tra xem thông tin khách hàng đã đủ hay chưa
    private boolean isCustomerInfoComplete(User user) {
        // Kiểm tra các trường thông tin cần thiết của khách hàng ở đây
        if (user.getUserName() == null || user.getPhoneNumber() == null || user.getAddress() == null) {
            return false;
        }
        return true;
    }


//    @Override
//    public void updateBooking(BookingUpdateForm bookingUpdateForm) {
//        bookingRepository.save(mapper.map(bookingUpdateForm, Booking.class));
//    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
