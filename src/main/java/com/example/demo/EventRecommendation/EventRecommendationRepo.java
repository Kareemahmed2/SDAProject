package com.example.demo.EventRecommendation;

import com.example.demo.Booking.Event;
import com.example.demo.Booking.SearchingCriteria;
import com.example.demo.DataStorage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventRecommendationRepo implements EventRecommendationRepository {
    @Override
    public List<Event> searchEvents(SearchingCriteria searchingCriteria) {
        return DataStorage.searchEvents(searchingCriteria);

    }
}
