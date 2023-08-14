package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", unique = true, nullable = false)
    private Integer bookingId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Column(name = "booking_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime bookingDate;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
