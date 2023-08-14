package com.travelapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public enum OrderStatus {
        PENDING,
        CANCELLED,
        COMPLETED
    }
}
