package com.example.demo.Booking;

public class Test {
    public static void main(String[] args) {
        Room room = new Room("single", 2, 100.0);
        System.out.println(room.getRoomType());
        System.out.println(room.roomType.getRoomType());
        System.out.println(room.roomType.name());
        System.out.println(room.getRoomType().equals(room.roomType.name()));
    }
}
