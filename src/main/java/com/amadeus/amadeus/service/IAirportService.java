package com.amadeus.amadeus.service;

import com.amadeus.amadeus.dto.AirportDto;
import com.amadeus.amadeus.model.entity.Airport;

import java.util.List;

public interface IAirportService {
    Airport createAirport(AirportDto airportDto);
    List<Airport> getAirports();
    Airport getAirport(Long id);
    Airport updateAirport(Long id, AirportDto airportDto);
    boolean deleteAirport(Long id);
}
