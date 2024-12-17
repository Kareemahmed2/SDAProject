package com.example.demo.Booking;

import org.springframework.http.ResponseEntity;

public class BookCommand extends BookingCommand{

    public BookCommand(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public ResponseEntity<String> execute() {

        behaviour.book();
        return null;
    }
}
