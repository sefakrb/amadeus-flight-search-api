package com.amadeus.amadeus.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SearchDto {
    private String departureCity;
    private String arrivalCity;
    private String departureDate;
    private String returnDate;

    public SearchDto(){}
    public SearchDto(String departureCity, String arrivalCity, String departureDate, String returnDate) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
