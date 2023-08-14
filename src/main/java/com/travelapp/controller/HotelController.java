package com.travelapp.controller;

import com.travelapp.dto.HotelDTO;
import com.travelapp.dto.UserDTO;
import com.travelapp.entity.Hotel;
import com.travelapp.entity.User;
import com.travelapp.service.interfaceService.IHotelService;
import com.travelapp.validation.anotation.UserExistsById;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/hotels")
public class HotelController {
    @Autowired
    private IHotelService hotelService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam String address,
                                                    @RequestParam LocalDateTime checkInDate,
                                                    @RequestParam LocalDateTime checkOutDate) {
        List<Hotel> hotels = hotelService.searchHotels(address, checkInDate, checkOutDate);
        return ResponseEntity.ok(hotels);
    }

    // tìm bằng Id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createHotel(@RequestBody HotelDTO hotelDTO) {
        hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{hotelId}")
    public ResponseEntity<Void> updateHotel(@PathVariable Integer hotelId, @RequestBody HotelDTO hotelDTO) {
        hotelService.updateHotel(hotelId, hotelDTO);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.noContent().build();
    }
}
