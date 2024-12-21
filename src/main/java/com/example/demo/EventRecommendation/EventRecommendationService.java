package com.example.demo.EventRecommendation;

import com.example.demo.Booking.EventRecommendationTrigger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EventRecommendationService {
    @EventListener
    @Async
    public void RecommendationOnHotel(EventRecommendationTrigger eventRecommendationTrigger) {
        System.out.println(eventRecommendationTrigger.getBookingRequest().getName()+" "+eventRecommendationTrigger.getLocation()+" "+eventRecommendationTrigger.getBookingRequest().getDate());
    }
}