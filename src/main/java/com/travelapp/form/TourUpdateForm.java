package com.travelapp.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
public class TourUpdateForm {
    @NotNull(message = "{TourForm.id.NotNull}")
    private Integer id;

    @NotBlank(message = "{TourForm.name.NotBlank}")
    @Length(max = 50, message = "{TourForm.name.Length}")
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
    private Integer duration;

    @NotBlank(message = "{TourForm.thumbnailUrl.NotBlank}")
    @Length(max = 1023, message = "{TourForm.thumbnailUrl.Length}")
    private String thumbnailUrl;

    @NotBlank(message = "{TourForm.destination.NotBlank}")
    @Length(max = 255, message = "{TourForm.destination.Length}")
    private String destination;

}
