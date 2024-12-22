package com.example.demo.NotificationHandler;

import com.example.demo.DataStorage;
import com.example.demo.UserManagement.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationRepo implements NotificationRepository {
    @Override
    public User getUserByUsername(String username) {
        return DataStorage.getUserByUsername(username);
    }

    @Override
    public void sendNotification(String username, Notification notification) {
        DataStorage.addNotification(username, notification);
    }
}
