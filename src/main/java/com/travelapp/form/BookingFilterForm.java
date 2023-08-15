package com.travelapp.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class BookingFilterForm {
    private String search;
    private String email;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime minBookingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime maxBookingDate;
}
