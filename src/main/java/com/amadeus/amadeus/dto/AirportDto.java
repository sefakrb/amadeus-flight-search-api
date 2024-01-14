package com.amadeus.amadeus.dto;

public class AirportDto {
    private String city;
    public AirportDto() {}
    public AirportDto(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
