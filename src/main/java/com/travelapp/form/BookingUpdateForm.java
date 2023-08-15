package com.travelapp.form;

import com.travelapp.entity.Booking;
import com.travelapp.validation.anotation.BookingExistsById;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class BookingUpdateForm extends FormBase{
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
