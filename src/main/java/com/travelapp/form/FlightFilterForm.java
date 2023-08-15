package com.travelapp.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightFilterForm {
    private String flightCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String airLineName;
    private Double maxPrice;
    private Double minPrice;
}
