package com.travelapp.dto;

import com.travelapp.entity.Flight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FlightDTO {
    private Integer flightId;
    private String flightCode;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String destination;
    private String airLineName;
    private double price;
    private List<TicketDTO> tickets;

}
