package com.example.demo.UserManagement;

import com.example.demo.Booking.Booking;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;

public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String email;
    private int age;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age= age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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
}
