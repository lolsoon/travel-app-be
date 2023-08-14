package com.travelapp.service.interfaceService;

import com.travelapp.dto.HotelDTO;
import com.travelapp.entity.Hotel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface IHotelService {
    void createHotel(HotelDTO hotelDTO);

    List<Hotel> getAllHotels();

    Hotel findHotelById(Integer hotelId);

    Hotel findHotelByName(String hotelName);

    List<Hotel> findHotelByAddress(String address);

    List<Hotel> searchHotels(String address, LocalDateTime checkInDate, LocalDateTime checkOutDate);

    List<Hotel> findByPriceLessThan(BigDecimal pricePerNight);

    void updateHotel(Integer hotelId, HotelDTO hotelDTO);

    void deleteHotel(Integer hotelId);
}
