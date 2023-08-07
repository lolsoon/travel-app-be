package com.travelapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "flightCode", nullable = false, unique = true)
    private String flightCode;

    @Column(name = "departureStart", nullable = false)
    private LocalDateTime departureStart;

    @Column(name = "description", nullable = false)
    private String destination;

    @Column(name = "ticketPrice")
    private double ticketPrice;

    public Flight(Integer id, String flightCode, LocalDateTime departureStart, String destination, double ticketPrice) {
        this.id = id;
        this.flightCode = flightCode;
        this.departureStart = departureStart;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    public double getPrice() {
        return this.ticketPrice = ticketPrice;
    }
}