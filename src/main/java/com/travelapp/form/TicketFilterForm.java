package com.travelapp.form;

import com.travelapp.entity.Flight;
import com.travelapp.entity.Hotel;
import com.travelapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TicketFilterForm extends FormBase {


    private Set<User> users;

    private Set<Flight> flight;

    private Set<Hotel> hotel;

    private String departureLocation; // Lọc theo địa điểm khởi hành

    private String destination; // Lọc theo điểm đến

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime departureDate; // Lọc theo ngày khởi hành

    @PositiveOrZero(message = "Giá vé chưa phù hợp")
    private Double minPrice; // Lọc theo giá vé tối thiểu

    @PositiveOrZero(message = "Giá vé chưa phù hợp ")
    private Double maxPrice; // Lọc theo giá vé tối đa
    private Integer quantity;

}
