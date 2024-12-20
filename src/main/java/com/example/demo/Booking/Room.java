package com.example.demo.Booking;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Room {
    public enum RoomType {
        SINGLE("single"),
        DOUBLE("double"),
        FAMILY("family");

        private final String name;

        RoomType(String name) {
            this.name = name;
        }

        public String getRoomType() {
            return name;
        }
        @JsonCreator
        public static RoomType fromString(String key) {
            for (RoomType type : RoomType.values()) {
                if (type.name.equalsIgnoreCase(key)) {  // Case-insensitive matching
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid room type: " + key);
        }
    }

    protected RoomType roomType;
    protected int roomNumber;
    protected double price;

    public Room(String roomType, int roomNumber, double price) {
        this.roomType = RoomType.fromString(roomType);
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public Room() {}

    public String getRoomType() {
        return roomType.getRoomType();
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
