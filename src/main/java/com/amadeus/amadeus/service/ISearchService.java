package com.amadeus.amadeus.service;

import com.amadeus.amadeus.model.entity.Flight;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ISearchService {
    List<Flight> oneWayFlight(String departureDate, String departureCity, String arrivalCity) throws ParseException;
    List<Flight> twoWayFlight(String departureDate, String returnDate, String departureCity, String arrivalCity) throws ParseException;

}
