package com.travelapp.repository;

import com.travelapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
    // lấy thông tin khách sạn theo id
    Hotel findHotelById(int hotelId);

    Hotel findHotelByName(String hotelName);

    Hotel findHotelByAddress(String address);

    List<Hotel> getAllHotels();

    List<Hotel> findByPriceLessThan(double price);

}
