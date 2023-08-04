package com.travelapp.dto;

import com.travelapp.entity.Flight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FlightDTO {
    private Integer id;
    private String flightCode;
    private LocalDateTime departureStart;
    private String destination;
    private double ticketPrice;


    public Flight toEntity() {
        return new Flight(id,flightCode,departureStart,destination,ticketPrice);
    }
}
