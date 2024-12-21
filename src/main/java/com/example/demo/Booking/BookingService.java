package com.example.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    protected Behaviour behaviour;
    protected final BookingRepoImp repo;

    @Autowired
    public BookingService(Behaviour behaviour, BookingRepoImp repo) {
        this.behaviour = behaviour;
        this.repo = repo;
    }


    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }
    public void book(BookingRequest bookingRequest) {
        this.behaviour.book(bookingRequest);
    }
    public List Search(SearchingCriteria searchingCriteria) {
        return this.behaviour.Search(searchingCriteria);
    }
}