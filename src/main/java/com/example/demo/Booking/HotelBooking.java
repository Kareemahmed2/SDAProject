package com.example.demo.Booking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelBooking extends Booking {

    @JsonProperty
    String roomType;


    public HotelBooking(String name, Room roomType, int NumberOfDays) {
        this.name = name;
        this.roomType = roomType.getRoomType();
        this.totalCost = roomType.getPrice() * NumberOfDays;
    }
    @Override
    public String toString() {
        return "HotelBooking{" +
                " name='" + name + '\'' +
                ", roomType='" + roomType + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
    public HotelBooking() {}
}