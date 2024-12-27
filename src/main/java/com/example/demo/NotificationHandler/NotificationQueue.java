package com.example.demo.NotificationHandler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class NotificationQueue {
    private final NotificationDispatcher dispatcher;
    private Queue<Notification> queue = new ConcurrentLinkedQueue<>();

    public NotificationQueue(NotificationDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Async
    public void addNotification(Notification notification) {
        queue.add(notification);
        System.out.println("Notification added to queue: " + notification.getMessage());
        processNotifications();
    }
    @Async
    public void processNotifications() {
        while (!queue.isEmpty()) {
            Notification notification = queue.poll();
            System.out.println("Processing notification: " + notification.getMessage()+ " for user:"+notification.getBookingRequest().getUsername());
            dispatcher.dispatchNotification(notification);
        }
    }
}
