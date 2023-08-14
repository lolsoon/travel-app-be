package com.travelapp.repository;

import com.travelapp.entity.Booking;
import com.travelapp.entity.Tour;
import com.travelapp.entity.User;
import com.travelapp.form.BookingUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>, JpaSpecificationExecutor<Booking> {

    //  Tìm kiếm Booking theo khoảng thơi gian
    List<Booking> findByBookingDateBetween(LocalDateTime bookingStart, LocalDateTime bookingEnd);

    //    Booking findBookingById(int bookingId);
    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId")
    List<Booking> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT b FROM Booking b WHERE b.bookingStatus = :bookingStatus")
            List<Booking> findBookingByStatus(@Param("bookingStatus") Enum bookingStatus);
    //    List<Booking> findByTourId(Integer tourId);
//    List<Booking> findByFlightId(Integer flightId);
//    List<Booking> findByHotelId(Integer hotelId);
//    List<Booking> findBookingByStatus(Booking.BookingStatus bookingStatus);

//    Page<Booking> findAllBookings(Specification<Booking> buildWhere, Pageable pageable);

    //    void createBooking(Booking booking);
//    void updateBooking(BookingUpdateForm bookingUpdateForm);
//    void deleteBooking(Integer bookingId);
}
