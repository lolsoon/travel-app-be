package com.travelapp.dto;

import com.travelapp.entity.Tour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TourDTO {
    private Integer tourId;
    private String tourName;
    private String description;
    private double price;
    private double salePrice;
    private int duration;
    private String thumbnailUrl;
    private String destination;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

//    public Tour toEntity() {
//        return new Tour(id,tourName,description,price,duration);
//    }
}
