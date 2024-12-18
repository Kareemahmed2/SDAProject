package com.example.demo.Booking;

import java.util.ArrayList;

public class HotelBehaviour implements Behaviour{
    @Override
    public Booking book() {
        return new HotelBooking();
    }

    @Override
    public ArrayList<Entities> Search() {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
