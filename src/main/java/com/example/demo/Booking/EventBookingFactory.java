package com.example.demo.Booking;

public class EventBookingFactory extends BookingService {

    public EventBookingFactory() {
        this.setBehaviour(new EventBehaviour());
    }
    @Override
    public Booking book() {
        return null;
    }
}
