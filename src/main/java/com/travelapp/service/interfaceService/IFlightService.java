package com.travelapp.service.interfaceService;

import com.travelapp.dto.FlightDTO;
import com.travelapp.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface IFlightService {

    void createFlight(FlightDTO flightDTO);

    List<Flight> getAllFlights();

    Flight findFlightById(Integer flightId);

    Flight findFlightByCode(String flightCode);
    List<Flight> searchFlights( String destination, LocalDateTime departureDate);
    List<Flight> findFlightByLessThanPrice(double price);

    void updateFlight(Integer id, FlightDTO flightDTO);

    void deleteFlight(Integer flightId);
}
