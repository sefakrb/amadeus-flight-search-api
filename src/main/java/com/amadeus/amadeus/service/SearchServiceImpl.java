package com.amadeus.amadeus.service;

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
public class SearchServiceImpl implements ISearchService {
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;

    public SearchServiceImpl(AirportRepository airportRepository, FlightRepository flightRepository) {
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> oneWayFlight(String departureDate, String departureCity, String arrivalCity) throws ParseException {
        nullControl(departureDate, departureCity, arrivalCity);
        Airport depAirport = airportRepository.findByCity(departureCity);
        Airport arrAirport = airportRepository.findByCity(arrivalCity);
        if (depAirport == null) {
            throw new NullPointerException("departure city does not exist");
        }
        if (arrAirport == null) {
            throw new NullPointerException("arrival city does not exist");
        }

        Date depDate = Helper.stringToDate(departureDate);

        List<Flight> flightList = flightRepository.findAllByDepartureAirportAndArrivalAirportAndDepartureDate(
                depAirport.getId(), arrAirport.getId(), depDate);

        return flightList;
    }

    @Override
    public List<Flight> twoWayFlight(String departureDate, String returnDate, String departureCity, String arrivalCity) throws ParseException {
        if (returnDate == null) {
            throw new NullPointerException("returnDate is null");
        }
        nullControl(departureDate, departureCity, arrivalCity);

        Airport depAirport = airportRepository.findByCity(departureCity);
        Airport arrAirport = airportRepository.findByCity(arrivalCity);

        if (depAirport == null) {
            throw new NullPointerException("departure city does not exist");
        }
        if (arrAirport == null) {
            throw new NullPointerException("arrival city does not exist");
        }

        Date depDate = Helper.stringToDate(departureDate);
        Date retDate = Helper.stringToDate(returnDate);

        List<Flight> twoWayFlights = new ArrayList<>();

        List<Flight> departureFlightsList = flightRepository.findAllByDepartureAirportAndArrivalAirportAndDepartureDate(
                depAirport.getId(), arrAirport.getId(), depDate);
        if (departureFlightsList.isEmpty()) {
            throw new NullPointerException("There is no suitable flight");
        }
        twoWayFlights.add(departureFlightsList.get(0));

        List<Flight> returnFlightsList = flightRepository.findAllByDepartureAirportAndArrivalAirportAndDepartureDate(
                arrAirport.getId(), depAirport.getId(), retDate);
        if (returnFlightsList.isEmpty()) {
            throw new NullPointerException("There is no suitable flight");
        }
        twoWayFlights.add(returnFlightsList.get(0));

        return twoWayFlights;
    }

    public void nullControl(String departureDate, String departureCity, String arrivalCity) {
        if (Helper.isStringNullOrEmpty(departureDate)) {
            throw new NullPointerException("departureDate is null");
        }
        if (departureCity == null) {
            throw new NullPointerException("departureCity is null");
        }
        if (arrivalCity == null) {
            throw new NullPointerException("arrivalCity is null");
        }
    }
}
