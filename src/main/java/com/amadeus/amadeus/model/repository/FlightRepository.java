package com.amadeus.amadeus.model.repository;


import com.amadeus.amadeus.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByDepartureAirport(Long departureAirport);
    Flight findByArrivalAirport(Long arrivalAirport);
    List<Flight> findAllByDepartureAirport(Long departureAirport);
    List<Flight> findAllByArrivalAirport(Long arrivalAirport);
    List<Flight> findAllByDepartureAirportAndArrivalAirport(Long departureAirport, Long arrivalAirport);
    List<Flight> findAllByDepartureAirportAndArrivalAirportAndDepartureDate(
                                Long departureAirport, Long arrivalAirport, Date departureDate);
    List<Flight> findAllByDepartureAirportAndArrivalAirportAndReturnDate(
            Long departureAirport, Long arrivalAirport, Date returnDate);
    List<Flight> findAllByDepartureAirportAndArrivalAirportAndDepartureDateAndReturnDate(
            Long departureAirport, Long arrivalAirport, Date departureDate, Date returnDate);
    Flight findById(long id);
}