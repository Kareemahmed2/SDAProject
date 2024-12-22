package com.example.demo.EventRecommendation;

import com.example.demo.Booking.Event;

import java.util.List;

public class Recommendation {
    String username;
    private List<Event> events;

    public Recommendation(String username,List<Event> events) {
        this.username = username;
        this.events = events;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
