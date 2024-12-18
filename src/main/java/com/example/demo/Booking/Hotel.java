package com.example.demo.Booking;

import javax.persistence.*;
import java.util.ArrayList;


public class Hotel extends Entities{

    @Id
    @SequenceGenerator(name = "hotel_sequence", sequenceName = "hotel_sequence", allocationSize = 1)
    @GeneratedValue(generator = "hotel_sequence", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    private ArrayList<Room> rooms = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
