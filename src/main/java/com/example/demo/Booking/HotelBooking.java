package com.example.demo.Booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class HotelBooking {

    @Id
    @SequenceGenerator(name = "hotelbooking_sequence", sequenceName = "hotelbooking_sequence", allocationSize = 1)
    @GeneratedValue(generator = "hotelbooking_sequence", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Hotel hotel;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
