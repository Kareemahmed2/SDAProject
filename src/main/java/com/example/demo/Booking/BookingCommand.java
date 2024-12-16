package com.example.demo.Booking;

import org.springframework.http.ResponseEntity;

public abstract class BookingCommand {
    Behaviour behaviour;
    public abstract ResponseEntity<String> execute();
}
