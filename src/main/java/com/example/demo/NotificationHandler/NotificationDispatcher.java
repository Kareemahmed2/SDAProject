package com.example.demo.NotificationHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationDispatcher {
    private final NotificationRepo notificationRepo;

    @Autowired
    public NotificationDispatcher(NotificationRepo notificationRepo) {

        this.notificationRepo = notificationRepo;
    }

    public void dispatchNotification(Notification notification) {
        String username = notification.getBookingRequest().getUsername();
        System.out.println("Dispatching notification for user: " + username);
        notificationRepo.sendNotification(username, notification);
    }
}
