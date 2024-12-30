package com.example.demo.Dashboard;

import com.example.demo.Booking.Booking;
import com.example.demo.DataStorage;
import com.example.demo.NotificationHandler.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DashboardRepo implements DashboardRepository {
    @Override
    public List<Notification> getNotifications(String username) {
        return DataStorage.getUserByUsername(username).getNotifications();
    }

    @Override
    public List<Booking> getBookings(String username) {
        return DataStorage.getUserByUsername(username).getBookings();
    }
}
