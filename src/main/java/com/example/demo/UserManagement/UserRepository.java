package com.example.demo.UserManagement;

public interface UserRepository {
    User GetUserByUsername(String username);
    Boolean ValidateUser(String username, String password);
    void updateUser(User user);

    void deleteUser(String username);

}
