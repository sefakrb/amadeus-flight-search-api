package com.amadeus.amadeus.controller;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.model.entity.Flight;
import com.amadeus.amadeus.model.mapper.FlightMapper;
import com.amadeus.amadeus.service.FlightServiceImpl;
import com.amadeus.amadeus.service.MockFlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController("/flight")
public class FlightController {
    private final FlightServiceImpl flightService;
    private final MockFlightService mockFlightService;

    public FlightController(FlightServiceImpl flightService, MockFlightService mockFlightService) {
        this.flightService = flightService;
        this.mockFlightService = mockFlightService;
    }

    @Operation(summary = "create flight")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Flight created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlightController.class))})
    })*/
    @PostMapping(value = "/create-flight")
    public FlightDto createFlight(@RequestBody FlightDto flightDto) {
        try {
            Flight flight = flightService.createFlight(flightDto);
            return FlightMapper.INSTANCE.flightToFlightDto(flight);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "get flights")
    @GetMapping(value = "/get-flights")
    public List<FlightDto> getFlights() {
        try {
            List<Flight> flights = flightService.getFlights();
            List<FlightDto> flightDtos = new ArrayList<>();
            for (Flight flight : flights) {
                flightDtos.add(FlightMapper.INSTANCE.flightToFlightDto(flight));
            }
            return flightDtos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "get flight")
    @GetMapping(value = "/get-flight")
    public FlightDto getFlights(@RequestParam(name = "id") Long id) {
        try {
            Flight flight = flightService.getFlight(id);
            return FlightMapper.INSTANCE.flightToFlightDto(flight);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "update flight")
    @PutMapping(value = "/update-flight")
    public FlightDto updateFlight(@RequestParam(name = "id") Long id, @RequestBody FlightDto flightDto) {
        try {
            Flight flight = flightService.updateFlight(id, flightDto);
            return FlightMapper.INSTANCE.flightToFlightDto(flight);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "delete flight")
    @DeleteMapping(value = "/delete-flight")
    public boolean deleteFlight(@RequestParam(name = "id") Long id) {
        try {
            boolean isDeleted = flightService.deleteFlight(id);
            return isDeleted;
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "create mock data")
    @GetMapping(value = "/create-mock-flight")
    @Scheduled(cron = "0 0 * * *")
    public void createMockFlight() throws ParseException {
        try {
            mockFlightService.createFlight();
        } catch (Exception e) {
            throw e;
        }
    }
}
