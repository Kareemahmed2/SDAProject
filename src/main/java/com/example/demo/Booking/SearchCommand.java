package com.example.demo.Booking;

import org.springframework.http.ResponseEntity;

public class SearchCommand extends BookingCommand {

    public SearchCommand(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public ResponseEntity<String> execute() {
        behaviour.Search();
        return null;
    }
}
