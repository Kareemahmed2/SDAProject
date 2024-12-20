package com.example.demo.Booking;

import java.time.LocalDate;


public class Event {

    private LocalDate StartDate;
    private LocalDate EndDate;
    private String name;
    private String description;
    private String location;

    public Event(LocalDate startDate, LocalDate endDate, String name, String description, String location) {
        StartDate = startDate;
        EndDate = endDate;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public Event() {
    }


    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
