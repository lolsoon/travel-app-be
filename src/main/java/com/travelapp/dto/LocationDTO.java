package com.travelapp.dto;

import com.travelapp.entity.Location;

public class LocationDTO {
    private Integer id;
    private String locationName;
    private String description;
    public Location toEntity() {
        return new Location(id,locationName,description);
    }
}
