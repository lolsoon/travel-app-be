package com.travelapp.service.interfaceService;

import com.travelapp.entity.Location;
import com.travelapp.entity.Tour;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ITourService {
    void createTour(Tour tour);

    List<Tour> getAllTours();

    Tour findTourById(Integer tourId);

    List<Tour> findTourByLocation(Location location);

    List<Tour> findTourByDuration(int duration);

    List<Tour> findTourByPrice(double price);

//    boolean existsByTourName( String tourName);

    List<Tour> findTourByStartDate(LocalDateTime startDate);

    void updateTour(Tour tour);

    void deleteTour(Integer tourId);
}
