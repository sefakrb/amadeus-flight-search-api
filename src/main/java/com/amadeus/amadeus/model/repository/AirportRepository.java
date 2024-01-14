package com.amadeus.amadeus.model.repository;

import java.util.List;

import com.amadeus.amadeus.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByCity(String city);
    Airport findById(long id);
}