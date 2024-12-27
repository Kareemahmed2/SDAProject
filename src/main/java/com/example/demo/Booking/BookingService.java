package com.example.demo.Booking;

import com.example.demo.NotificationHandler.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    protected Behaviour behaviour;
    protected final BookingRepoImp repo;
    protected final NotificationService notificationService;

    @Autowired
    public BookingService(Behaviour behaviour, BookingRepoImp repo, NotificationService notificationService) {
        this.behaviour = behaviour;
        this.repo = repo;
        this.notificationService = notificationService;
    }


    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }
    public void book(BookingRequest bookingRequest) {
        if(bookingRequest==null) throw new RuntimeException("Booking request is empty");
        this.behaviour.book(bookingRequest);
        notificationService.sendBookingNotification(bookingRequest);
    }
    public List Search(SearchingCriteria searchingCriteria) {
        return this.behaviour.Search(searchingCriteria);
    }
}