package com.example.demo.UserManagement;

import com.example.demo.DataStorage;
import org.springframework.stereotype.Service;

@Service
public class UserRepo implements UserRepository{

    @Override
    public User GetUserByUsername(String username) {
        return DataStorage .getUserByUsername(username);
    }

    @Override
    public Boolean ValidateUser(String username, String password) {
        if (DataStorage.getUserByUsername(username) == null) {
            return false;
        }
        return DataStorage.getUserByUsername(username).getPassword().equals(password);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
