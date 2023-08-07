package com.travelapp.repository;

import com.travelapp.entity.Location;
import com.travelapp.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Integer> {

    // tìm kiếm theo Id
    Tour findTourById(int tourId);

    List<Tour> findTourByLocation(Location location);

    // Lấy thông tin các tour
    List<Tour> getAllTours();

    // Phương thức kiểm tra xem tour có tồn tại theo Id
    public boolean existsByTourId(int tourId);

    // Phương thức kiểm tra xem tour có tồn tại theo location
    public boolean existsByLocation(String location);

    // lấy danh sách Tour theo duration

    List<Tour> findTourByDuration(int duration);

    List<Tour> findTourByPrice(double price);

    List<Tour> findTourByStartDate(LocalDateTime startDate);
}
