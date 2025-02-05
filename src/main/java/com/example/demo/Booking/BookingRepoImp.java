package com.example.demo.Booking;

import com.example.demo.DataStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRepoImp implements BookingRepository{
    @Override
    public void AddHotel(Hotel hotel) {
        DataStorage.addHotel(hotel);
    }

    @Override
    public void AddEvent(Event event) {
        DataStorage.addEvent(event);
    }

    @Override
    public void AddBooking(String username, Booking booking) {
        DataStorage.addBooking(username, booking);
    }

    @Override
    public List<Hotel> searchHotels(SearchingCriteria criteria) {
        return DataStorage.searchHotels(criteria);
    }

    @Override
    public List<Event> searchEvents(SearchingCriteria criteria) {
        return DataStorage.searchEvents(criteria);
    }

    @Override
    public Hotel GetHotelByName(String name) {
        return DataStorage.getHotelByName(name);
    }

    @Override
    public Event GetEventByName(String name) {
        return DataStorage.getEventByName(name);
    }
}
