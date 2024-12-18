package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface Behaviour {

    Booking book();
    ArrayList<Entities> Search();
    boolean cancel();
}