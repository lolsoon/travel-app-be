package com.travelapp.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "numberOfPeople", nullable = false)
    private int numberOfPeople;

    @Column(name = "totalCost", nullable = false)
    private double totalCost;

    @Column(name = "bookingDate", nullable = false)
    @CreationTimestamp
    private Date bookingDate;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    private Tour tour;
}
