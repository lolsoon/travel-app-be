package com.travelapp.repository;

import com.travelapp.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Integer> , JpaSpecificationExecutor<Tour> {

    // tìm kiếm theo Id
    Tour findTourById(int tourId);

    // Lấy thông tin các tour
    List<Tour> getAllTours();

    // Phương thức kiểm tra xem tour có tồn tại theo Id
    public boolean existsByTourId(int tourId);

    // lấy danh sách Tour theo duration

    List<Tour> findTourByDuration(int duration);

    List<Tour> findByPriceBetween(double minPrice, double maxPrice);

    List<Tour> findTourByStartDate(LocalDateTime startDate);
    void createTour(Tour tour);
    void updateTour(Tour tour);
//    void deleteTour(Integer tourId);

}
