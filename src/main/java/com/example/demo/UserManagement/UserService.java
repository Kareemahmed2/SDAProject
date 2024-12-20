package com.example.demo.UserManagement;

import com.example.demo.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {

    private final DataStorage dataStorage;

    @Autowired
    public UserService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void addUser(User user) {
        DataStorage.addUser(user);
    }
    public User getUser(String username) {
        return DataStorage.getUserByUsername(username);
    }

    public static Optional<User> GetUserByUsername(String username) {
        return Optional.ofNullable(DataStorage.getUserByUsername(username));
        }

    public static boolean ValidateUser(String username, String password) {
        return DataStorage.validateUser(username, password);
    }

    public boolean updateUser(User user) {
        return DataStorage.updateUser(user);
    }

    public boolean deleteUser(String username) {
        return DataStorage.deleteUser(username);
    }
}

