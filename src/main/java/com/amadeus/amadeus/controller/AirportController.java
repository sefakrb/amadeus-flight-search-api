package com.amadeus.amadeus.controller;

import com.amadeus.amadeus.dto.AirportDto;
import com.amadeus.amadeus.model.entity.Airport;
import com.amadeus.amadeus.model.mapper.AirportMapper;
import com.amadeus.amadeus.service.AirportServiceImpl;
import com.amadeus.amadeus.service.MockAirportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController("/airport")
public class AirportController {
    private final AirportServiceImpl airportService;
    private final MockAirportService mockAirportService;

    public AirportController(AirportServiceImpl airportService, MockAirportService mockAirportService) {
        this.airportService = airportService;
        this.mockAirportService = mockAirportService;
    }

    @Operation(summary = "create Airport")
    /*@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Airport created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AirportController.class))})
    })*/
    @PostMapping(value = "/create-airport")
    public AirportDto createAirport(@RequestBody AirportDto airportDto) {
        try {
            Airport airport = airportService.createAirport(airportDto);
            return AirportMapper.INSTANCE.airportToAirportDto(airport);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "get airports")
    @GetMapping(value = "/get-airports")
    public List<AirportDto> getAirports() {
        try {
            List<Airport> airports = airportService.getAirports();
            List<AirportDto> airportDtos = new ArrayList<>();
            for (Airport airport : airports) {
                airportDtos.add(AirportMapper.INSTANCE.airportToAirportDto(airport));
            }
            return airportDtos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "get airport")
    @GetMapping(value = "/get-airport")
    public AirportDto getAirports(@RequestParam(name = "id") Long id) {
        try {
            Airport airport = airportService.getAirport(id);
            return AirportMapper.INSTANCE.airportToAirportDto(airport);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "update airport")
    @PutMapping(value = "/update-airport")
    public AirportDto updateAirport(@RequestParam(name = "id") Long id, @RequestBody AirportDto airportDto) {
        try {
            Airport airport = airportService.updateAirport(id, airportDto);
            return AirportMapper.INSTANCE.airportToAirportDto(airport);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "delete airport")
    @DeleteMapping(value = "/delete-airport")
    public boolean deleteAirport(@RequestParam(name = "id") Long id) {
        try {
            boolean isDeleted = airportService.deleteAirport(id);
            return isDeleted;
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "create mock airports")
    @GetMapping(value = "/create-mock-airport")
    @Scheduled(cron = "0 0 * * *")
    public void createMockAirport() {
        try {
            mockAirportService.createAirport();
        } catch (Exception e) {
            throw e;
        }
    }


}
