package com.travelapp.form;

import com.travelapp.entity.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class BookingFilterForm {
    private String search;
    private Integer userId;
    private Booking.BookingStatus bookingStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minBookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxBookingDate;


}
