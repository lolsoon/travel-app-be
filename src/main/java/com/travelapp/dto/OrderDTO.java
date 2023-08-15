package com.travelapp.dto;

import com.travelapp.entity.Order;

import java.time.LocalDateTime;

public class OrderDTO {
    private Integer   orderId;
    private UserDTO user;
    private LocalDateTime createDate;
    private TicketDTO ticket;
    private int quantity;
    private Order.OrderStatus orderStatus;
}
