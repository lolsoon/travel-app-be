package com.travelapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", unique = true, nullable = false)
    private Integer flightId;

    @Column(name = "flight_code", nullable = false, unique = true)
    private String flightCode;

    @Column(name = "departure_date", nullable = false)
    private LocalDateTime departureDate;

    @Column(name = "arrival_date", nullable = false)
    private LocalDateTime arrivalDate;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "air_line_name", nullable = false)
    private String airLineName;
    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Flight(Integer flightId, String flightCode, LocalDateTime departureDate, LocalDateTime arrivalDate, String destination,String airLineName, double price) {
        this.flightId = flightId;
        this.flightCode = flightCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.destination = destination;
        this.price = price;
        this.airLineName = airLineName;
    }

    public double getPrice() {
        return this.price = price;
    }
}