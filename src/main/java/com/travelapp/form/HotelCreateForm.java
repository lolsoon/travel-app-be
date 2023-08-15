package com.travelapp.form;

import com.travelapp.entity.Hotel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

public class HotelCreateForm {
    @NotBlank(message = "{HotelForm.hotelName.NotBlank}")
    @Length(max = 225, message = "{HotelForm.hotelName.Length}")
    private String hotelName;

    @NotBlank(message = "{HotelForm.address.NotBlank}")
    @Length(max = 225, message = "{HotelForm.address.Length}")
    private String address;

    @NotBlank(message = "{HotelForm.phoneNumber.NotBlank}")
    @Length(max = 225, message = "{HotelForm.phoneNumber.Length}")
    private String phoneNumber;

    @NotBlank(message = "{HotelForm.thumbnailUrls.NotBlank}")
    @Length(max = 1023, message = "{HotelForm.thumbnailUrls.Length}")
    private List<Hotel> thumbnailUrls;

    @NotNull(message = "{HotelForm.checkInDate.NotNull}")
    private LocalDateTime checkInDate;

    @NotNull(message = "{HotelForm.checkOutDate.NotNull}")
    private LocalDateTime checkOutDate;

    @NotNull(message = "{HotelForm.pricePerNight.NotNull}")
    @PositiveOrZero(message = "{HotelForm.pricePerNight.PositiveOrZero}")
    private Double pricePerNight;

    @NotNull(message = "{HotelForm.totalPrice.NotNull}")
    @PositiveOrZero(message = "{HotelForm.totalPrice.PositiveOrZero}")
    private Double totalPrice;

}
