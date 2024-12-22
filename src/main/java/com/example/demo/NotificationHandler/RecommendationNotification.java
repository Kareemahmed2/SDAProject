package com.example.demo.NotificationHandler;

import com.example.demo.Booking.Event;
import com.example.demo.EventRecommendation.Recommendation;

public class RecommendationNotification extends Notification {

    private Recommendation recommendation;

    public RecommendationNotification() {
        super();
    }

    public RecommendationNotification(Recommendation recommendation) {
        super();
        this.recommendation = recommendation;
    }
    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    protected String generateMessage() {
        StringBuilder temp = new StringBuilder("Hi " + recommendation.getUsername() + ", we have a recommendation for you!");

        for (Event event : recommendation.getEvents()) {
            temp.append("\n\nEvent: ").append(event.getName());
            temp.append("\nDescription: ").append(event.getDescription());
            temp.append("\nDate: ").append(event.getStartDate());
            temp.append("\nLocation: ").append(event.getLocation());
        }
        return temp.toString();
    }
}
