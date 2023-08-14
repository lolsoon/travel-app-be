package com.travelapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true, nullable = false)
    private Integer paymentId;
    @ManyToOne
    @JoinColumn(name = "booking_id") // Tên cột trong bảng payment để lưu ID của booking
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING) // Sử dụng EnumType.STRING để lưu trữ giá trị của Enum dưới dạng chuỗi
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    public enum PaymentMethod {
        VNPAY,
        MOMOPAY
    }

    public enum PaymentStatus {
        UNPAID,
        PAID,
        CANCELLED
    }
}
