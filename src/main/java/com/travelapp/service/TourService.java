package com.travelapp.service;

import com.travelapp.entity.Location;
import com.travelapp.entity.Tour;
import com.travelapp.repository.ITourRepository;
import com.travelapp.service.interfaceService.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;

public class TourService implements ITourService {
    @Autowired
    private ITourRepository tourRepository;

    @Override
    public void createTour(Tour tour) {
        // Truy xuất thông tin về người dùng hiện tại
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Kiểm tra có phải ADMIN
        if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            tourRepository.save(tour);
        } else {
            throw new RuntimeException("Not allowed");
        }
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findTourById(Integer tourId) {
        return tourRepository.findTourById(tourId);
    }

    @Override
    public List<Tour> findTourByLocation(Location location) {
        return tourRepository.findTourByLocation(location);
    }

    @Override
    public List<Tour> findTourByDuration(int duration) {
        return tourRepository.findTourByDuration(duration);
    }

    @Override
    public List<Tour> findTourByPrice(double price) {
        return tourRepository.findTourByPrice(price);
    }

    @Override
    public List<Tour> findTourByStartDate(LocalDateTime startDate) {
        return tourRepository.findTourByStartDate(startDate);
    }

    @Override
    public void updateTour(Tour tour) {
        // Lấy thông tin người dùng hiện tại từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Người dùng chưa đăng nhập");
        }
        //Kiểm tra Admin role hay không
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
        if (!isAdmin) {
            throw new IllegalArgumentException("Không có quyền update tour");
        }
        // Lưu vào repo
        tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Integer tourId) {
        // check exists tour ?
        Tour tour = tourRepository.findTourById(tourId);
        if (tour == null) {
            throw new IllegalArgumentException("Tour không tồn tại!");
        }
        tourRepository.delete(tour);
    }
}
