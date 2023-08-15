package com.travelapp.dto;

import com.travelapp.entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {
    private Integer ticketId;
    private FlightDTO flight;
    private HotelDTO hotel;
    private List<BookingDTO> bookings;
    private String departureLocation;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private Double price;
    private int quantity;
}
