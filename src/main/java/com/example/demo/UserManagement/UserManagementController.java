package com.example.demo.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userManagement")
public class UserManagementController {
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @Autowired
    public UserManagementController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/register")
    public void register(@RequestBody User user) {
        userService.addUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        if(UserService.ValidateUser(authRequest.getUsername(), authRequest.getPassword())) {
            return jwtUtil.generateToken(authRequest.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
