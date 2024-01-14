package com.amadeus.amadeus.service;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.model.entity.Flight;

import java.util.List;

public interface IFlightService {
    Flight createFlight(FlightDto flightDto);
    List<Flight> getFlights();
    Flight getFlight(Long id);
    Flight updateFlight(Long id, FlightDto flightDto);
    boolean deleteFlight(Long id);
}
