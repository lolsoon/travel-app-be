package com.travelapp.dto;

import com.travelapp.entity.payment.MomoPayment;

import java.util.Date;

public class PaymentDTO {
    private Integer id;
    private double amount;
    private Date paymentDate;
    private MomoPaymentDTO momoPaymentDTO;
    private VNPaymentDTO vnPaymentDTO;
    private UserDTO userDTO;
}
