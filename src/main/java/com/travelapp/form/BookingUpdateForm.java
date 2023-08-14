package com.travelapp.form;

import com.travelapp.entity.Booking;
import com.travelapp.validation.anotation.BookingExistsById;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class BookingUpdateForm {
    @NotNull(message = "{BookingForm.id.NotNull}")
    @BookingExistsById
    private Integer id;


    private double totalAmount;  // Số tiền tổng cộng mới
    private Booking.BookingStatus bookingStatus;  // Trạng thái đặt tour mới

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime bookingDate;  // Ngày đặt tour mới

    private String userName;  // Tên người đặt tour mới
    private Integer hotelId;  // ID khách sạn mới
    private Integer flightId;  // ID chuyến bay mới
    private Integer tourId;  // ID tour mới
    @NotNull(message = "{Form.id.NotNull}")
    private Integer categoryId;
}
