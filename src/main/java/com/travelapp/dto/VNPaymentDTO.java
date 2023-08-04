package com.travelapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VNPaymentDTO {
    private Integer id;
    private String vnpayTransactionId;
    private String vnpayBankCode;
}
