package com.travelapp.form;

import com.travelapp.entity.Payment;
import com.travelapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PaymentFilterForm extends FormBase{
    private Integer userId;
    private Payment.PaymentStatus paymentStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;
    private Payment.PaymentMethod paymentMethod;
}
