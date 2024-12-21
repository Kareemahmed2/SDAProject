package com.example.demo.Booking;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class EventBooking extends Booking{
    @JsonProperty
    String Location;
    @JsonProperty
    LocalDate date;

    public EventBooking(String name,String Location,LocalDate date,double totalCost) {
        this.name = name;
        this.Location = Location;
        this.date = date;
        this.totalCost = totalCost;
    }
    @Override
    public String toString() {
        return "EventBooking{" +
                " name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                ", date='" + date + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
    public EventBooking(){}
}
