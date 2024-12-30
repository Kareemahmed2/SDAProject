package com.example.demo.Dashboard;

import com.example.demo.Booking.Booking;
import com.example.demo.NotificationHandler.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DashboardRepository {
    public List<Notification> getNotifications(String username);
    public List<Booking> getBookings(String username);
}
