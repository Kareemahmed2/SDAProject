package com.example.demo.Booking;

import com.example.demo.UserManagement.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;
    protected final ApplicationEventPublisher eventPublisher;

    @Autowired
    public BookingController(BookingService bookingService, ApplicationEventPublisher eventPublisher) {
        this.bookingService = bookingService;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/BookHotel")
    public String bookHotel(@RequestBody HotelBookingRequest request,@RequestHeader("Authorization") String authorization) {
        String username = new JWTUtil().extractUsername(authorization);
        bookingService.setBehaviour(new HotelBehaviour(bookingService.repo));
        request.setUsername(username);
        bookingService.book(request);
        String Location=bookingService.repo.GetHotelByName(request.name).getLocation();
        EventRecommendationTrigger eventRecommendationTrigger = new EventRecommendationTrigger(request,Location);
        eventPublisher.publishEvent(eventRecommendationTrigger);
        return "Hotel"+ request.getName()+" Booked for "+ request.getUsername();
    }
    @PostMapping("/BookEvent")
    public String bookEvent(@RequestBody EventBookingRequest request,@RequestHeader("Authorization") String authorization) {
        String username = new JWTUtil().extractUsername(authorization);
        bookingService.setBehaviour(new EventBehaviour(bookingService.repo));
        request.setUsername(username);
        bookingService.book(request);
        return "Book Event";
    }
    @GetMapping("/SearchHotels")
    public List searchHotels(@RequestBody SearchingCriteria criteria) {
        bookingService.setBehaviour(new HotelBehaviour(bookingService.repo));
        return bookingService.Search(criteria);
    }
    @GetMapping("/SearchEvents")
    public List searchEvents(@RequestBody SearchingCriteria criteria) {
        bookingService.setBehaviour(new EventBehaviour(bookingService.repo));
        return bookingService.Search(criteria);
    }

}