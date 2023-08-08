package com.travelapp.dto;

import java.util.Date;

public class PaymentDTO {
    private Integer id;
    private double amount;
    private Date paymentDate;
    private MomoPaymentDTO momoPaymentDTO;
    private UserDTO userDTO;
}
