package com.amadeus.amadeus.model.mapper;

import com.amadeus.amadeus.dto.AirportDto;
import com.amadeus.amadeus.model.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);
    AirportDto airportToAirportDto(Airport airport);

}
