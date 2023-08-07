package com.travelapp.entity;

import com.travelapp.entity.payment.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @Column(name = "id", unique = true, nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id",referencedColumnName = "id", nullable = false)
    private Payment payment;


    private double totalAmount;
    private Date orderDate;

    public double calculateTotalAmount() {
        double flightPrice = flight.getPrice();
        double hotelPrice = hotel.getPrice();
        return flightPrice + hotelPrice;
    }
}
