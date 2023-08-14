package com.travelapp.dto;

import com.travelapp.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Integer paymentId;
    private Integer bookingId;
    private Integer userId;
    private double amount;
    private Payment.PaymentMethod paymentMethod;
    private Payment.PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
}
