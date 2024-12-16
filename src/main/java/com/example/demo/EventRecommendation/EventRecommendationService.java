package com.example.demo.EventRecommendation;

import com.example.demo.Booking.Event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventRecommendationService {
    @EventListener
    public void onEvent(Event event) {
        System.out.println(event.getName());
    }
}
