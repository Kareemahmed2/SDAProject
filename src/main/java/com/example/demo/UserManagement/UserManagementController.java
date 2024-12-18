package com.example.demo.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")


public class UserManagementController {
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @Autowired
    public UserManagementController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        if (UserService.ValidateUser(authRequest.getUsername(), authRequest.getPassword())) {
            return ResponseEntity.ok(jwtUtil.generateToken(authRequest.getUsername()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        boolean isUpdated = userService.updateUser(user);
        if (isUpdated) {
            return "User updated successfully.";
        }
        throw new RuntimeException("User update failed.");
    }
        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable Long id) {
            boolean isDeleted = userService.deleteUser(id);
            if (isDeleted) {
                return "User deleted successfully.";
            }
            throw new RuntimeException("User deletion failed.");
        }
    }


