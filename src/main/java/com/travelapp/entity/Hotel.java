package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", unique = true, nullable = false)
    private Integer hotelId;

    @Column(name ="hotel_name",nullable = false)
    private String hotelName;

    @Column(name ="address",nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name ="check_in_date",nullable = false)
    @CreationTimestamp
    private LocalDateTime checkInDate;

    @Column(name ="check_out_date",nullable = false)
    @CreationTimestamp
    private LocalDateTime checkOutDate;

    @Column(name ="price_per_night",nullable = false)
    private Double pricePerNight;

    @Column(name = "price_total")
    private Double totalPrice;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    public Hotel(Integer hotelId, String hotelName, String address, String phoneNumber, Double pricePerNight, Double totalPrice) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pricePerNight = pricePerNight;
        this.totalPrice = totalPrice;
    }
}
