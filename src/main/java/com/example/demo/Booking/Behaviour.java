package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Behaviour<T,R extends BookingRequest> {

    void book(R bookingRequest);
    List<T> Search();
    boolean cancel();
}