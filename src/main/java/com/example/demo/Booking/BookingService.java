package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public abstract class BookingService {
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();

    protected Behaviour behaviour;

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public abstract Booking book() ;
    public ArrayList<Entities> Search() {
        return this.behaviour.Search();
    }
    public void cancel() {
        this.behaviour.cancel();
    }
}