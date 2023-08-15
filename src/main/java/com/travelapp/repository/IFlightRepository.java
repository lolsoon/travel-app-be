package com.travelapp.repository;

import com.travelapp.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightById (int flightId);

    Flight findFlightByCode (String flightCode);

    List<Flight> findByDestinationAndDepartureDate(String destination,LocalDateTime departureDate);

    List<Flight> findByDestination (String destination);

    List<Flight> findByPrice (double price);

    List<Flight> getAllFlights();
    List<Flight> getFlightsByAirline();

}
