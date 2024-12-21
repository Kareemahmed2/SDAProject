package com.example.demo.Booking;

import java.time.LocalDate;

public class HotelBookingRequest extends BookingRequest{
    private Room.RoomType roomType;
    private int NumberOfDays;
    private LocalDate date;

    public HotelBookingRequest(String HotelName, String username,LocalDate date ,String roomType, int numberOfDays) {
        this.username = username;
        this.name = HotelName;
        this.date = date;
        this.roomType = Room.RoomType.fromString(roomType);
        NumberOfDays = numberOfDays;
    }

    public Room.RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(Room.RoomType roomType) {
        this.roomType = roomType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfDays() {
        return NumberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        NumberOfDays = numberOfDays;
    }

}
