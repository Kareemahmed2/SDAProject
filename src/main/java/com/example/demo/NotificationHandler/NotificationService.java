package com.example.demo.NotificationHandler;

import com.example.demo.Booking.BookingRequest;
import com.example.demo.EventRecommendation.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationQueue notificationQueue;

    @Autowired
    public NotificationService(NotificationQueue notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    @Async
    public void sendBookingNotification(BookingRequest bookingRequest) {
        Notification notification = new SMSNotification();
        System.out.println("Booking request owner: " + bookingRequest.getUsername());
        notification.setBookingRequest(bookingRequest);
        notification.CreateNotification();
        notificationQueue.addNotification(notification);
    }
    public void sendRecommendationNotification(Recommendation recommendation) {
        Notification notification=new RecommendationNotification(recommendation);
        notification.CreateNotification();
        notification.getBookingRequest().setUsername(recommendation.getUsername());
        notificationQueue.addNotification(notification);
    }
}