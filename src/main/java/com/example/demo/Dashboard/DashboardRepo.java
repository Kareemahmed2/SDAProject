package com.example.demo.Dashboard;

import com.example.demo.Booking.Booking;
import com.example.demo.DataStorage;
import com.example.demo.NotificationHandler.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DashboardRepo implements DashboardRepository {
    @Override
    public List<String> getNotifications(String username) {
        List<String> notifications = new java.util.ArrayList<>();
        for (Notification notification : DataStorage.getUserByUsername(username).getNotifications()) {
            notifications.add(notification.getMessage());
        }
        return notifications;
    }

    @Override
    public List<Booking> getBookings(String username) {
        return DataStorage.getUserByUsername(username).getBookings();
    }
}
