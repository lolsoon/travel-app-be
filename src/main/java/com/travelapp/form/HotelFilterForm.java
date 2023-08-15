package com.travelapp.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelFilterForm {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private Double maxPricePerNight;
    private Double minPricePerNight;
}
