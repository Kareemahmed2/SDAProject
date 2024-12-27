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
        if(event==null) throw new RuntimeException("Event not found: " + eventBookingRequest.getName());
        Booking eventBooking = new EventBooking(event.getName(),event.getLocation(),event.getStartDate(),event.getTicketPrice());
        repo.AddBooking(eventBookingRequest.getUsername(),eventBooking);
    }

    @Override
    public List<Event> Search(SearchingCriteria searchingCriteria) {
        if(searchingCriteria==null) throw new RuntimeException("Search criteria cannot be empty");
        return repo.searchEvents(searchingCriteria);
    }

}
