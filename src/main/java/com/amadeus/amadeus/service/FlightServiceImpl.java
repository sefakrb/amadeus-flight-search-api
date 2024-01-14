package com.amadeus.amadeus.service;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.model.entity.Airport;
import com.amadeus.amadeus.model.entity.Flight;
import com.amadeus.amadeus.model.repository.AirportRepository;
import com.amadeus.amadeus.model.repository.FlightRepository;
import com.amadeus.amadeus.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;


    public FlightServiceImpl(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public Flight createFlight(FlightDto flightDto) {
        nullControl(flightDto);

        Airport depAirport = airportRepository.findById(flightDto.getDepartureAirport()).orElse(null);
        Airport arrAirport = airportRepository.findById(flightDto.getArrivalAirport()).orElse(null);

        if(depAirport == null || arrAirport == null) {
            throw new NullPointerException("Departure or Arrival Airport does not exist");
        }

        Flight flight = new Flight(flightDto.getDepartureAirport(),
                flightDto.getArrivalAirport(),
                flightDto.getDepartureDate(),
                flightDto.getReturnDate(),
                flightDto.getPrice());

        flightRepository.save(flight);

        return flight;
    }

    @Override
    public List<Flight> getFlights() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList;
    }

    @Override
    public Flight getFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight == null) {
            throw new NullPointerException("flight is not available");
        }
        return flight;
    }

    @Override
    public Flight updateFlight(Long id, FlightDto flightDto) {
        if (id == null) {
            throw new NullPointerException("id is null");
        }
        nullControl(flightDto);

        Flight flight = flightRepository.findById(id).orElse(null);

        if (flight == null) {
            throw new NullPointerException("Flight is not present");
        }

        flight.setArrivalAirport(flightDto.getArrivalAirport());
        flight.setDepartureAirport(flight.getDepartureAirport());
        flight.setDepartureDate(flight.getDepartureDate());
        flight.setReturnDate(flight.getReturnDate());
        flight.setPrice(flight.getPrice());
        flightRepository.save(flight);

        return flight;
    }

    @Override
    public boolean deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight == null) {
            throw new NullPointerException("Flight is not present");
        }
        flightRepository.deleteById(id);
        return true;
    }

    public void nullControl(FlightDto flightDto) {
        if (Helper.isNullObject(flightDto.getArrivalAirport())) {
            throw new NullPointerException("ArrivalAirport is null");
        }
        if (Helper.isNullObject(flightDto.getReturnDate())) {
            throw new NullPointerException("ReturnDate is null");
        }
        if (Helper.isNullObject(flightDto.getDepartureAirport())) {
            throw new NullPointerException("DepartureAirport is null");
        }
        if (Helper.isNullObject(flightDto.getPrice())) {
            throw new NullPointerException("Price is null");
        }
    }
}
