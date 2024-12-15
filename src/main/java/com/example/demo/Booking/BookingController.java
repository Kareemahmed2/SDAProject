package com.example.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/Search hotels")
    public String searchHotels() {
        return "Search";
    }
    @GetMapping("/Search events")
    public String searchEvents() {
        return "Search";
    }
    @PostMapping("/Book Hotel")
    public String bookHotel() {
        return "Book Hotel";
    }
    @PostMapping("/Book Event")
    public String bookEvent() {
        return "Book Event";
    }

    @DeleteMapping("/Cancel hotel booking")
    public String cancelHotelBooking() {
        return "Cancel";
    }

    @DeleteMapping("/Cancel event booking")
    public String cancelEventBooking() {
        return "Cancel";
    }
}
