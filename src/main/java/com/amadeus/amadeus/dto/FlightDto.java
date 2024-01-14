package com.amadeus.amadeus.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FlightDto {
    private Long departureAirport;
    private Long arrivalAirport;
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss:SSS")
    private Date departureDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss:SSS")
    private Date returnDate;
    private Long price;

    public FlightDto(){}
    public FlightDto(Long departureAirport, Long arrivalAirport, Date departureDate, Date returnDate, Long price) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    public Long getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Long departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Long getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Long arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
