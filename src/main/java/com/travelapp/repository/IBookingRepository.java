package com.travelapp.repository;

import com.travelapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

    //  Tìm kiếm Booking theo số lượng người tham gia
    List<Booking> findByNumberOfPeople(int numberOfPeople);

    //  Tìm kiếm Booking theo ngày đặt
    List<Booking> findByBookingDate(Date bookingDate);

    //  Tìm kiếm Booking theo tổng chi phí
    List<Booking> findByTotalCost(double totalCost);

    List<Booking> getAllBookings();
}
