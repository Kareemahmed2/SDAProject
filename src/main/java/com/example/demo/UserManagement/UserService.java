package com.example.demo.UserManagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class UserService {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<AuthRequest> authRequests = new ArrayList<>();
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
        authRequests.add(new AuthRequest("user1", "password1"));
        authRequests.add(new AuthRequest("user2", "password2"));
        authRequests.add(new AuthRequest("user3", "password3"));
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

    public boolean updateUser(User user) {
        Optional<User> existingUserOptional = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst();

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            return true;
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}

