package com.example.demo.Booking;

import org.springframework.context.ApplicationEvent;

public class EventRecommendationTrigger extends ApplicationEvent {
    private final HotelBookingRequest bookingRequest;
    private final String Location;
    public EventRecommendationTrigger(HotelBookingRequest bookingRequest, String location) {
        super(bookingRequest);
        this.bookingRequest = bookingRequest;
        Location = location;
    }

    public HotelBookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public String getLocation() {
        return Location;
    }

}
