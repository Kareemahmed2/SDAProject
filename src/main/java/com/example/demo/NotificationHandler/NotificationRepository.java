package com.example.demo.NotificationHandler;

import com.example.demo.UserManagement.User;

public interface NotificationRepository {
    public User getUserByUsername(String username);
    public void sendNotification(String username, Notification notification);
}
