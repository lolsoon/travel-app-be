package com.travelapp.dto;

import com.travelapp.entity.Hotel;

import java.math.BigDecimal;
import java.util.List;

public class HotelDTO {
    private Integer hotelId;
    private String hotelName;
    private String address;
    private String phoneNumber;
    private BigDecimal pricePerNight;
    private BigDecimal totalPrice;
    private List<TicketDTO> tickets;
}
