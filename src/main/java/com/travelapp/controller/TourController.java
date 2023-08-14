package com.travelapp.controller;

import com.travelapp.entity.Tour;
import com.travelapp.entity.User;
import com.travelapp.service.interfaceService.ITourService;
import com.travelapp.validation.anotation.UserExistsById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/tours")
public class TourController {
    @Autowired
    private ITourService tourService;

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{tourId}")
    public Tour getTourById(@PathVariable Integer tourId) {
        return tourService.findTourById(tourId);
    }

    @PostMapping
    public void createTour(@RequestBody Tour tour) {
        tourService.createTour(tour);
    }

    @PutMapping("/{tourId}")
    public void updateTour(@PathVariable Integer tourId, @RequestBody Tour tour) {
        tourService.updateTour(tourId, tour);
    }

    @DeleteMapping("/{tourId}")
    public ResponseEntity<String> deleteById(@PathVariable("id")  Integer tourId) {
        Tour tourToDelete = tourService.findTourById(tourId);

        if (tourToDelete == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("không tìm thấy tour này");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Không thể xóa user có role là ADMIN");
            }
        }
        tourService.deleteTour(tourId);
        return ResponseEntity.ok("tour deleted successfully");
    }

    @GetMapping("/duration/{duration}")
    public List<Tour> getToursByDuration(@PathVariable int duration) {
        return tourService.findTourByDuration(duration);
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public List<Tour> getToursByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {
        return tourService.findTourByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/startDate/{startDate}")
    public List<Tour> getToursByStartDate(@PathVariable LocalDateTime startDate) {
        return tourService.findTourByStartDate(startDate);
    }
}
