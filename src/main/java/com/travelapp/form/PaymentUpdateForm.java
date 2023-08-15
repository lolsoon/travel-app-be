package com.travelapp.form;

import com.travelapp.entity.Booking;
import com.travelapp.entity.Payment;
import com.travelapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentUpdateForm {
    @NotNull(message = "{PaymentForm.paymentId.NotNull}")
    private Integer paymentId;

    @NotNull(message = "{PaymentForm.booking.NotNull}")
    private Booking booking;

    @NotNull(message = "{PaymentForm.user.NotNull}")
    private User user;

    @NotBlank(message = "{PaymentForm.amount.NotNull}")
    private double amount;

    @NotNull(message = "{PaymentForm.paymentDate.NotNull}")
    private LocalDateTime paymentDate;

    @NotNull(message = "{PaymentForm.paymentMethod.NotNull}")
    private Payment.PaymentMethod paymentMethod;

    @NotNull(message = "{PaymentForm.paymentStatus.NotNull}")
    private Payment.PaymentStatus paymentStatus;
}
