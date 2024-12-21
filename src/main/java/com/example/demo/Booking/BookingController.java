package com.example.demo.Booking;

import com.example.demo.UserManagement.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/SearchHotels")
    public String searchHotels() {
        bookingService.SearchHotels();
        return "Search";
    }
    @GetMapping("/SearchEvents")
    public String searchEvents() {
        return "Search";
    }
    @PostMapping("/BookHotel")
    public String bookHotel(@RequestBody HotelBookingRequest request,@RequestHeader("Authorization") String authorization) {
        String username = new JWTUtil().extractUsername(authorization);
        bookingService.setBehaviour(new HotelBehaviour(bookingService.repo));
        request.setUsername(username);
        bookingService.book(request);
        return "Book Hotel";
    }
    @PostMapping("/BookEvent")
    public String bookEvent(@RequestBody EventBookingRequest request,@RequestHeader("Authorization") String authorization) {
        String username = new JWTUtil().extractUsername(authorization);
        bookingService.setBehaviour(new EventBehaviour(bookingService.repo));
        request.setUsername(username);
        bookingService.book(request);
        return "Book Event";
    }

    @DeleteMapping("/CancelHotelBooking")
    public String cancelHotelBooking() {
        return "Cancel";
    }

    @DeleteMapping("/CancelEventBooking")
    public String cancelEventBooking() {
        return "Cancel";
    }
}