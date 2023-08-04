package com.travelapp.dto;

import com.travelapp.entity.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private OrderStatus status;
    private FlightDTO flight;
    private HotelDTO hotel;
    private LocationDTO location;
    private UserDTO user;
    private PaymentDTO payment;
    private double totalAmount;
    private Date orderDate;

    public OrderDTO(Integer id, OrderStatus status, FlightDTO flight, HotelDTO hotel, LocationDTO location, UserDTO user, PaymentDTO payment, double totalAmount, Date orderDate) {
        this.id = id;
        this.status = status;
        this.flight = flight;
        this.hotel = hotel;
        this.location = location;
        this.user = user;
        this.payment = payment;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }
}
