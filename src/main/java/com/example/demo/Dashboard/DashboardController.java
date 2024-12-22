package com.example.demo.Dashboard;

import com.example.demo.Booking.Booking;
import com.example.demo.UserManagement.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dashboard")
@RestController
public class DashboardController {
    private final DashboardService dashboardService;
    private final JWTUtil jwtUtil;

    @Autowired
    public DashboardController(DashboardService dashboardService, JWTUtil jwtUtil) {
        this.dashboardService = dashboardService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> printBookings(@RequestHeader("Authorization") String authorization) {
        String username=jwtUtil.extractUsername(authorization);
        return ResponseEntity.ok(dashboardService.printBooking(username));
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<String>> printNotifications(@RequestHeader("Authorization") String authorization) {
        String username=jwtUtil.extractUsername(authorization);
        return ResponseEntity.ok(dashboardService.printNotifications(username));
    }
}
