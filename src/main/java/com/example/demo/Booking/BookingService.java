package com.example.demo.Booking;

import org.springframework.stereotype.Service;

@Service
public abstract class BookingService {
    Behaviour behaviour;

    public abstract void book();
    public abstract void cancel();
    public abstract void Search();
}
