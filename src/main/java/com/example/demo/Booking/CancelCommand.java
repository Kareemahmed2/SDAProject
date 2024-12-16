package com.example.demo.Booking;

import org.springframework.http.ResponseEntity;

public class CancelCommand extends BookingCommand {


    public CancelCommand(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public ResponseEntity<String> execute() {
        behaviour.cancel();
        return null;
    }

}
