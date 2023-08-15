package com.travelapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookingDTO {

    private Integer bookingId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private double totalAmount;
    private int numberOfPeople;
    private LocalDateTime bookingDate;
    private String note;
    private TicketDTO ticket;
}
