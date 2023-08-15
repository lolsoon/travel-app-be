package com.travelapp.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public class FlightUpdateForm extends FormBase {
    @NotBlank(message = "{FlightForm.flightCode.NotBlank}")
    @Length(max = 225, message = "{FlightForm.flightCode.Length}")
    private String flightCode;

    @NotBlank(message = "{FlightForm.destination.NotBlank}")
    @Length(max = 225, message = "{FlightForm.destination.Length}")
    private String destination;

    @NotBlank(message = "{FlightForm.airLineName.NotBlank}")
    @Length(max = 225, message = "{FlightForm.airLineName.Length}")
    private String airLineName;

    @NotNull(message = "{FlightForm.departureDate.NotNull}")
    private LocalDateTime departureDate;

    @NotNull(message = "{FlightForm.arrivalDate.NotNull}")
    private LocalDateTime arrivalDate;

    @NotNull(message = "{FlightForm.price.NotNull}")
    @PositiveOrZero(message = "{HotelForm.price.PositiveOrZero}")
    private Double price;
}
