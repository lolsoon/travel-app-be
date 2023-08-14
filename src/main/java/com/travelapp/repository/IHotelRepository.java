package com.travelapp.repository;

import com.travelapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
    // lấy thông tin khách sạn theo id
    Hotel findHotelById(int hotelId);

    Hotel findHotelByName(String hotelName);

    List<Hotel> findHotelByAddress(String address);

    List<Hotel> getAllHotels();

    List<Hotel> findByPriceLessThan(BigDecimal pricePerNight);

    List<Hotel> findByLocationAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(String address, LocalDateTime checkOutDate, LocalDateTime checkInDate);
}
