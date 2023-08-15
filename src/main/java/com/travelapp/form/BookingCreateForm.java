package com.travelapp.form;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class BookingCreateForm {
    @NotBlank(message = "{BookingForm.fullName.NotBlank}")
    @Length(max = 50, message = "{BookingForm.fullName.Length}")
    private String fullName;

    @NotBlank(message = "{BookingForm.email.NotBlank}")
    @Length(max = 50, message = "{BookingForm.email.Length}")
    private String email;

    @NotBlank(message = "{BookingForm.phoneNumber.NotBlank}")
    @Length(max = 32, message = "{BookingForm.phoneNumber.Length}")
    private String phoneNumber;

    @NotBlank(message = "{BookingForm.address.NotBlank}")
    @Length(max = 50, message = "{BookingForm.address.Length}")
    private String address;

    @NotBlank(message = "{BookingForm.totalAmount.NotBlank}")
    private Double totalAmount;

    @NotBlank(message = "{BookingForm.numberOfPeople.NotBlank}")
    private Integer numberOfPeople;

    @NotNull(message = "{BookingForm.bookingDate.NotNull}")
    private LocalDateTime bookingDate;

    private String note;
}
