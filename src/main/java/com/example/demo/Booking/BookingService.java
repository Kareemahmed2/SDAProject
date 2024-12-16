package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingService {
    private ArrayList<BookingCommand> history= new ArrayList<BookingCommand>();

    public void execute(BookingCommand bookingCommand) {
        bookingCommand.execute();
    }
}