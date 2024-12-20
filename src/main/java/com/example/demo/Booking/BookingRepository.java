package com.example.demo.Booking;

import java.util.List;

public interface BookingRepository {
    public void AddHotel(Hotel hotel);
    public void AddEvent(Event event);
    public void AddBooking(String username, Booking booking);
    public List<Hotel> searchHotels();
    public List<Event> searchEvents();
    public Hotel GetHotelByName(String name);
    public Event GetEventByName(String name);
}
