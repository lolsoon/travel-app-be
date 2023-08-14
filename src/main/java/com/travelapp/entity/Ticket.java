package com.travelapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @Column(name = "departure_location", nullable = false)
    private String departureLocation;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "departure_date", nullable = false)
    private LocalDateTime departureDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
