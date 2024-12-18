package com.example.demo.Booking;

public class HotelBookingFactory extends BookingService {
    public HotelBookingFactory() {
        this.setBehaviour(new HotelBehaviour());
    }
    @Override
    public Booking book() {
        return behaviour.book();
    }
}