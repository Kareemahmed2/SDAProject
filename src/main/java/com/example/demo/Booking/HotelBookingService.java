package com.example.demo.Booking;

import org.springframework.stereotype.Service;

@Service
public class HotelBookingService extends BookingService {
    public HotelBookingService() {
        this.behaviour = new HotelBehaviour();
    }
    @Override
    public void book() {
        behaviour.book();
    }

    @Override
    public void cancel() {
        behaviour.cancel();
    }

    @Override
    public void Search() {
        behaviour.Search();
    }
}
