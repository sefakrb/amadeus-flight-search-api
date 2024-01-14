package com.amadeus.amadeus.service;

import com.amadeus.amadeus.model.entity.Airport;
import com.amadeus.amadeus.model.repository.AirportRepository;
import com.amadeus.amadeus.utils.Helper;
import org.springframework.stereotype.Service;

@Service
public class MockAirportService {
    private final AirportRepository airportRepository;
    public MockAirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void createAirport() {
        String city = "Ankara";
        Airport savedAirport = airportRepository.findByCity(city);
        if(savedAirport != null && savedAirport.getCity().equalsIgnoreCase(city)){
            throw new NullPointerException("City has been saved!");
        }

        String city2 = "İstanbul";
        Airport savedAirport2 = airportRepository.findByCity(city2);
        if(savedAirport2 != null && savedAirport2.getCity().equalsIgnoreCase(city2)){
            throw new NullPointerException("City has been saved!");
        }

        addAirport(city);
        addAirport(city2);

    }

    public void addAirport(String city) {
        Airport airport = new Airport();
        airport.setCity(city);
        airportRepository.save(airport);
    }
}
