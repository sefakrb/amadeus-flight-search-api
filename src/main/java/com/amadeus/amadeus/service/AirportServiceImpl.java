package com.amadeus.amadeus.service;

import com.amadeus.amadeus.dto.AirportDto;
import com.amadeus.amadeus.model.entity.Airport;
import com.amadeus.amadeus.model.repository.AirportRepository;
import com.amadeus.amadeus.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements IAirportService{
    private final AirportRepository airportRepository;
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    @Override
    public Airport createAirport(AirportDto airportDto) {
        if(Helper.isStringNullOrEmpty(airportDto.getCity())) {
            throw new NullPointerException("City is null");
        }

        Airport savedAirport = airportRepository.findByCity(airportDto.getCity());
        if(savedAirport != null
                && savedAirport.getCity().equalsIgnoreCase(airportDto.getCity())){
            throw new NullPointerException("City has been saved!");
        }

        Airport airport = new Airport();
        airport.setCity(airportDto.getCity());
        airportRepository.save(airport);

        return airport;
    }

    public List<Airport> getAirports(){
        List<Airport> airportList = airportRepository.findAll();
        return airportList;
    }

    public Airport getAirport(Long id){
        Airport airport = airportRepository.findById(id).orElse(null);
        if(airport == null) {
            throw new NullPointerException("city is not available");
        }
        return airport;
    }

    public Airport updateAirport(Long id, AirportDto airportDto) {
        if(id == null) {
            throw new NullPointerException("id is null");
        }
        if(airportDto == null) {
            throw new NullPointerException("new city name is null");
        }

        Airport airport = airportRepository.findById(id).orElse(null);

        if (airport == null) {
            throw new NullPointerException("Airport is not present");
        }

        airport.setCity(airportDto.getCity());
        airportRepository.save(airport);

        return airport;
    }

    public boolean deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id).orElse(null);
        if (airport == null) {
            throw new NullPointerException("Airport is not present");
        }
        airportRepository.deleteById(id);
        return true;
    }
}
