package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name ="hotelName",nullable = false)
    private String hotelName;

    @Column(name ="address",nullable = false)
    private String address;

    @Column(name = "phoneHotelNumber", nullable = false)
    private String phoneNumber;

    @Column(name ="checkInDate",nullable = false)
    @CreationTimestamp
    private Date checkInDate;

    @Column(name ="checkOutDate",nullable = false)
    @CreationTimestamp
    private Date checkOutDate;

    @Column(name ="price",nullable = false)
    private double price;

    public Hotel(Integer id, String hotelName, String address, String phoneNumber, double price) {
        this.id = id;
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.price = price;
    }
}
