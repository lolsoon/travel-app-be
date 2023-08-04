package com.travelapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MomoPaymentDTO {
    private Integer id;
    private String momoTransactionId;
    private String momoPhoneNumber;
}
