package com.example.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class HotelBehaviour implements Behaviour<Hotel, HotelBookingRequest>{
    private final BookingRepository repository;

    @Autowired
    public HotelBehaviour(BookingRepoImp bookingRepoImp) {
        this.repository = bookingRepoImp;
    }

    @Override
    public void book(HotelBookingRequest request) {
        Hotel hotel =repository.GetHotelByName(request.getName());
        Room room = hotel.getRooms().stream()
                .filter(room1 -> room1.getRoomType().equals(request.getRoomType().getRoomType())) // Compare enum values directly
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Room type not found: " + request.getRoomType()));
        Booking hotelBooking = new HotelBooking(request.getName(),room,request.getNumberOfDays());
        System.out.println(request.getUsername());
        repository.AddBooking(request.getUsername(), hotelBooking);
    }

    @Override
    public List<Hotel> Search() {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
