package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBehaviour implements Behaviour<Event,EventBookingRequest>{
    @Override
    public void book(EventBookingRequest eventBookingRequest) {

    }

    @Override
    public List<Event> Search() {
        return null;
    }

    @Override
    public boolean cancel() {

        return false;
    }
}
