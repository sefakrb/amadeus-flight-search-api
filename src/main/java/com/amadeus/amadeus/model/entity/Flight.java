package com.amadeus.amadeus.model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "departureAirport")
    private Long departureAirport;
    @Column(name = "arrivalAirport")
    private Long arrivalAirport;
    @Column(name = "departureDate")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss:SSS")
    private Date departureDate;
    @Column(name = "returnDate")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss:SSS")
    private Date returnDate;
    @Column(name = "price")
    private Long price;


    public Flight(){}
    public Flight( Long departureAirport, Long arrivalAirport, Date departureDate, Date returnDate, Long price) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
