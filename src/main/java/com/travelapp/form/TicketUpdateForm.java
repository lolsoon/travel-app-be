package com.travelapp.form;

import com.travelapp.entity.Flight;
import com.travelapp.entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TicketUpdateForm {

    private Long ticketId; // Thêm trường để lưu ID của vé

    @NotNull(message = "Flight is required")
    private Flight flight;

    @NotNull(message = "Hotel is required")
    private Hotel hotel;

    @NotBlank(message = "Departure location is required")
    private String departureLocation;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Departure date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime returnDate;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "TicketForm.price.PositiveOrZero")
    private Double price;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}
