package com.amadeus.amadeus.model.mapper;

import com.amadeus.amadeus.dto.FlightDto;
import com.amadeus.amadeus.model.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
    FlightDto flightToFlightDto(Flight flight);


}
