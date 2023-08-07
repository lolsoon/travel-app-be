package com.travelapp.dto;

import com.travelapp.entity.Location;
import com.travelapp.entity.Tour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TourDTO {
    private Integer id;
    private String tourName;
    private String description;
    private double price;
    private int duration;
    private Location location;

    public Tour toEntity() {
        return new Tour(id,tourName,description,price,duration,location);
    }
}
