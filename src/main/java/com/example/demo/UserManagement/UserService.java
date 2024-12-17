package com.example.demo.UserManagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class UserService {
    private static final ArrayList<User> users = new ArrayList<>();
    private static UserService userService;

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    public UserService() {
        users.add(new User("user1", "password1", "email1"));
        users.add(new User("user2", "password2", "email2"));
        users.add(new User("user3", "password3", "email3"));
    }
    public void addUser(User user) {
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public static Optional<User> GetUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        }

    public static boolean ValidateUser(String username, String password) {
        Optional<User> user = GetUserByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}

