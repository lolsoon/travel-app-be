package com.travelapp.controller;

import com.travelapp.dto.FlightDTO;
import com.travelapp.entity.Flight;
import com.travelapp.service.interfaceService.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/flights")
public class FlightController {
    @Autowired
    private IFlightService flightService;
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> findFlightById(@PathVariable Integer flightId) {
        Flight flight = flightService.findFlightById(flightId);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{flightCode}")
    public ResponseEntity<Flight> findFlightByCode(@PathVariable String flightCode) {
        Flight flight = flightService.findFlightByCode(flightCode);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestParam String destination,
                                                      @RequestParam LocalDateTime departureDate) {
        List<Flight> flights = flightService.searchFlights(destination, departureDate);
        return ResponseEntity.ok(flights);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createFlight(@RequestBody FlightDTO flightDTO) {
        flightService.createFlight(flightDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{flightId}")
    public ResponseEntity<Void> updateFlight(@PathVariable Integer flightId, @RequestBody FlightDTO flightDTO) {
        flightService.updateFlight(flightId, flightDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

}
