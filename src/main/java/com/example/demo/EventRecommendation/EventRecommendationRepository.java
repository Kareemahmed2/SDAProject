package com.example.demo.EventRecommendation;

import com.example.demo.Booking.Event;
import com.example.demo.Booking.SearchingCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventRecommendationRepository {
    public List<Event> searchEvents(SearchingCriteria searchingCriteria);
}
