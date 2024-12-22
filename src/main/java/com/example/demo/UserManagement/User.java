package com.example.demo.UserManagement;

import com.example.demo.Booking.Booking;
import com.example.demo.NotificationHandler.Notification;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private int age;
    @JsonProperty
    private ArrayList<Booking> bookings = new ArrayList<>();
    @JsonProperty
    private ArrayList<Notification> notifications = new ArrayList<>();

    public User(String username, String password, String email,int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age= age;
    }

    public User() {}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    public void AddBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void AddNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }
}
