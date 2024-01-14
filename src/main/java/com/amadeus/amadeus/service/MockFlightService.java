package com.amadeus.amadeus.service;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.model.entity.Airport;
import com.amadeus.amadeus.model.entity.Flight;
import com.amadeus.amadeus.model.repository.AirportRepository;
import com.amadeus.amadeus.model.repository.FlightRepository;
import com.amadeus.amadeus.utils.Helper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MockFlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public MockFlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public List<Flight> createFlight() throws ParseException {
        List<Flight> mockFlights = new ArrayList<>();

        String departureDateStr = "2024-01-01T00:50:54.699Z";
        String returnDateStr = "2024-01-02T00:50:54.699Z";

        Date departureDate = Helper.stringToDate(departureDateStr);
        Date returnDate = Helper.stringToDate(returnDateStr);

        FlightDto mockFlightDto = new FlightDto(102L, 103L,
                departureDate, returnDate, 500L);

        Flight flight = addFlight(mockFlightDto);

        String departureDateStr2 = "2024-01-10T00:50:54.699Z";
        String returnDateStr2 = "2024-01-11T00:50:54.699Z";

        Date departureDate2 = Helper.stringToDate(departureDateStr2);
        Date returnDate2 = Helper.stringToDate(returnDateStr2);

        FlightDto mockFlightDto2 = new FlightDto(103L, 102L,
                departureDate2, returnDate2, 1000L);

        Flight flight2 = addFlight(mockFlightDto2);

        mockFlights.add(flight);
        mockFlights.add(flight2);

        return mockFlights;
    }

    public Flight addFlight(FlightDto mockFlightDto) throws ParseException {
        Airport depAirport = airportRepository.findById(mockFlightDto.getDepartureAirport()).orElse(null);
        Airport arrAirport = airportRepository.findById(mockFlightDto.getArrivalAirport()).orElse(null);

        if(depAirport == null || arrAirport == null) {
            throw new NullPointerException("Departure or Arrival Airport does not exist");
        }

        Flight flight = new Flight(mockFlightDto.getDepartureAirport(),
                mockFlightDto.getArrivalAirport(),
                mockFlightDto.getDepartureDate(),
                mockFlightDto.getReturnDate(),
                mockFlightDto.getPrice());

        flightRepository.save(flight);

        return flight;
    }

}
