package com.travelapp.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class TourCreateForm{
    @NotBlank(message = "{TourForm.tourName.NotBlank}")
    @Length(max = 1023, message = "{TourForm.tourName.Length}")
    private String tourName;

    @NotBlank(message = "{TourForm.description.NotBlank}")
    @Length(max = 1023, message = "{TourForm.description.Length}")
    private String description;

    @NotNull(message = "{TourForm.price.NotNull}")
    @PositiveOrZero(message = "{TourForm.price.PositiveOrZero}")
    private Double price;

    @NotNull(message = "{TourForm.salePrice.NotNull}")
    @PositiveOrZero(message = "{TourForm.salePrice.PositiveOrZero}")
    private Double salePrice;

    @NotNull(message = "{TourForm.duration.NotNull}")
    @PositiveOrZero(message = "{TourForm.duration.PositiveOrZero}")
    private int duration;

    @NotBlank(message = "{TourForm.thumbnailUrl.NotBlank}")
    @Length(max = 255, message = "{TourForm.thumbnailUrl.Length}")
    private String thumbnailUrl;

}
