package com.example.demo.EventRecommendation;

import com.example.demo.Booking.Event;
import com.example.demo.Booking.EventRecommendationTrigger;
import com.example.demo.Booking.SearchingCriteria;
import com.example.demo.NotificationHandler.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventRecommendationService {
    private final NotificationService notificationService;
    private final EventRecommendationRepository eventRecommendationRepository;

    public EventRecommendationService(NotificationService notificationService, EventRecommendationRepository eventRecommendationRepository) {
        this.notificationService = notificationService;
        this.eventRecommendationRepository = eventRecommendationRepository;
    }

    @EventListener
    @Async
    public void RecommendationOnHotelBooking(EventRecommendationTrigger eventRecommendationTrigger) {
        System.out.println(eventRecommendationTrigger.getBookingRequest().getName()+" "+eventRecommendationTrigger.getLocation()+" "+eventRecommendationTrigger.getBookingRequest().getDate());
        SearchingCriteria searchingCriteria=new SearchingCriteria();
        searchingCriteria.setDate(eventRecommendationTrigger.getBookingRequest().getDate());
        searchingCriteria.setLocation(eventRecommendationTrigger.getLocation());
        List<Event> recommendedEvents=eventRecommendationRepository.searchEvents(searchingCriteria);
        if(recommendedEvents!=null){
            Recommendation recommendation= new Recommendation(eventRecommendationTrigger.getBookingRequest().getUsername(),recommendedEvents);
            notificationService.sendRecommendationNotification(recommendation);
        }
    }
}