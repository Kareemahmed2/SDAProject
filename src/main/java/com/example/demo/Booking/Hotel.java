package com.example.demo.Booking;

import java.util.ArrayList;


public class Hotel{
    private String name;
    private String location;
    private String description;

    private ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Hotel() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    public void addRoom(Room room){
        rooms.add(room);
    }

}