package com.travelapp.dto;

import com.travelapp.entity.BookingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private BookingStatus status;
    private FlightDTO flight;
    private HotelDTO hotel;
    private UserDTO user;
    private PaymentDTO payment;
    private double totalAmount;
    private Date orderDate;

    public OrderDTO(Integer id, BookingStatus status, FlightDTO flight, HotelDTO hotel, UserDTO user, PaymentDTO payment, double totalAmount, Date orderDate) {
        this.id = id;
        this.status = status;
        this.flight = flight;
        this.hotel = hotel;
        this.user = user;
        this.payment = payment;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }
}
