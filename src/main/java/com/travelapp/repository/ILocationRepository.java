package com.travelapp.repository;

import com.travelapp.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository {
    Location findLocationByName(String locationName);

    List<Location> getAllLocations();
}
