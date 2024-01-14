package com.amadeus.amadeus.controller;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.dto.SearchDto;
import com.amadeus.amadeus.model.entity.Flight;
import com.amadeus.amadeus.model.mapper.FlightMapper;
import com.amadeus.amadeus.service.SearchServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController("/search")
public class SearchController {
    private final SearchServiceImpl searchService;

    public SearchController(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/one-way-flight")
    public List<FlightDto> oneWayFlights(@RequestBody SearchDto searchDto) throws ParseException {
        try{
            List<Flight> flightList = searchService.oneWayFlight(searchDto.getDepartureDate(),
                    searchDto.getDepartureCity(), searchDto.getArrivalCity());
            List<FlightDto> flightDtos = new ArrayList<>();
            for (Flight flight : flightList) {
                flightDtos.add(FlightMapper.INSTANCE.flightToFlightDto(flight));
            }
            return flightDtos;
        }
        catch (Exception e){
            throw (e);
        }
    }

    @PostMapping("/two-way-flight")
    public List<FlightDto> twoWayFlights(@RequestBody SearchDto searchDto) throws ParseException {
        try{
            List<Flight> flightList = searchService.twoWayFlight(searchDto.getDepartureDate(),
                    searchDto.getReturnDate(), searchDto.getDepartureCity(), searchDto.getArrivalCity());
            List<FlightDto> flightDtos = new ArrayList<>();
            for (Flight flight : flightList) {
                flightDtos.add(FlightMapper.INSTANCE.flightToFlightDto(flight));
            }
            return flightDtos;
        }
        catch (Exception e){
            throw (e);
        }
    }
}
