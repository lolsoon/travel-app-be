package com.travelapp.service;

import com.travelapp.dto.FlightDTO;
import com.travelapp.dto.HotelDTO;
import com.travelapp.entity.Flight;
import com.travelapp.entity.Hotel;
import com.travelapp.repository.IFlightRepository;
import com.travelapp.service.interfaceService.IFlightService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService implements IFlightService {
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public void createFlight(FlightDTO flightDTO) {

        Flight  flight = new Flight();
        BeanUtils.copyProperties(flightDTO,flight);
        flight.setPrice(flightDTO.getPrice());
        flight.setDestination(flightDTO.getDestination());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setDepartureDate(flightDTO.getDepartureDate());
        flight.setArrivalDate(flightDTO.getArrivalDate());
        flight.setAirLineName(flightDTO.getAirLineName());
        flight.setFlightCode(flightDTO.getFlightCode());
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.getAllFlights();
    }

    @Override
    public Flight findFlightById(Integer flightId) {
        return flightRepository.findFlightById(flightId);
    }

    @Override
    public Flight findFlightByCode(String flightCode) {
        return flightRepository.findFlightByCode(flightCode);
    }

    @Override
    public List<Flight> searchFlights(String destination, LocalDateTime departureDate) {
        return flightRepository.findByDestinationAndDepartureDate(destination, departureDate);
    }

    @Override
    public List<Flight> findFlightByLessThanPrice(double ticketPrice) {
        return flightRepository.findByPrice(ticketPrice);
    }

    public void updateFlight(Integer flightId, FlightDTO flightDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalArgumentException("Người dùng chưa đăng nhập");
        }
        Flight flight = findFlightById(flightId);
        if (flight != null) {
            BeanUtils.copyProperties(flightDTO, flight);
        }
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
        if (!isAdmin) {
            throw new IllegalArgumentException("Không có quyền update hotel");
        }
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Integer flightId) {
        // check exists flight ?
        Flight flight = flightRepository.findFlightById(flightId);
        if (flight == null) {
            throw new IllegalArgumentException("Flight không tồn tại!");
        }
        flightRepository.delete(flight);
    }
}

