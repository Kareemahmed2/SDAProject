package com.example.demo.Dashboard;

import com.example.demo.Booking.Booking;
import com.example.demo.NotificationHandler.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    @Autowired
    public DashboardService(DashboardRepo dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }
    public List<Booking> printBooking(String username) {
        return dashboardRepository.getBookings(username);
    }
    public List<Notification> printNotifications(String username) {
        return dashboardRepository.getNotifications(username);
    }
}