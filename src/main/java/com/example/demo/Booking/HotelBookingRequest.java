package com.example.demo.Booking;

public class HotelBookingRequest extends BookingRequest{
    private Room.RoomType roomType;
    private int NumberOfDays;

    public HotelBookingRequest(String HotelName, String username, String roomType, int numberOfDays) {
        this.username = username;
        this.name = HotelName;
        this.roomType = Room.RoomType.fromString(roomType);
        NumberOfDays = numberOfDays;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Room.RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(Room.RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfDays() {
        return NumberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        NumberOfDays = numberOfDays;
    }
}
