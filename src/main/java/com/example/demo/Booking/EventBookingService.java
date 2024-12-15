package com.example.demo.Booking;

import org.springframework.stereotype.Service;

@Service
public class EventBookingService extends BookingService {

    public EventBookingService() {
        this.behaviour = new EventBehaviour();
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
