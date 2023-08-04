package com.travelapp.dto;

import com.travelapp.entity.Hotel;

public class HotelDTO {
    private Integer id;
    private String hotelName;
    private String address;
    private String phoneHotelNumber;
    private double price;

    public Hotel toEntity() {
        return new Hotel(id,hotelName,address,phoneHotelNumber,price);
    }
}
