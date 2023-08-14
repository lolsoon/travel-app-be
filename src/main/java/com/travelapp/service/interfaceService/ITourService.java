package com.travelapp.service.interfaceService;

import com.travelapp.entity.Tour;

import java.time.LocalDateTime;
import java.util.List;

public interface ITourService {
    void createTour(Tour tour);

    List<Tour> getAllTours();

    Tour findTourById(Integer tourId);

    List<Tour> findTourByDuration(int duration);

    List<Tour> findTourByPriceRange(double minPrice, double maxPrice);

//    boolean existsByTourName( String tourName);

    List<Tour> findTourByStartDate(LocalDateTime startDate);

    void updateTour(int id, Tour tour);

    void deleteTour(Integer tourId);
}
