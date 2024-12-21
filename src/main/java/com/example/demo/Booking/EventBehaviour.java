package com.example.demo.Booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBehaviour implements Behaviour<Event,EventBookingRequest>{
    private final BookingRepoImp repo;

    public EventBehaviour(BookingRepoImp repo) {
        this.repo = repo;
    }

    @Override
    public void book(EventBookingRequest eventBookingRequest) {
        Event event=repo.GetEventByName(eventBookingRequest.getName());
        Booking eventBooking = new EventBooking(event.getName(),event.getLocation(),event.getStartDate(),event.getTicketPrice());
        repo.AddBooking(eventBookingRequest.getUsername(),eventBooking);
    }

    @Override
    public List<Event> Search() {
        return null;
    }

    @Override
    public boolean cancel() {

        return false;
    }
}
