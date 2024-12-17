package com.example.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@Controller
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/Search hotels")
    public String searchHotels() {
        BookingCommand bookingCommand = new SearchCommand(new EventBehaviour());
        bookingService.execute(bookingCommand);
        return "Search";
    }
    @GetMapping("/Search events")
    public String searchEvents() {
        BookingCommand bookingCommand = new SearchCommand(new HotelBehaviour());
        return "Search";
    }
    @PostMapping("/Book Hotel")
    public String bookHotel(ApplicationEventPublisher applicationEventPublisher) {
        BookingCommand bookingCommand = new BookCommand(new HotelBehaviour());
        applicationEventPublisher.publishEvent(new Booking());
        return "Book Hotel";
    }
    @PostMapping("/Book Event")
    public String bookEvent() {
        BookingCommand bookingCommand = new BookCommand(new EventBehaviour());
        return "Book Event";
    }

    @DeleteMapping("/Cancel hotel booking")
    public String cancelHotelBooking() {
        BookingCommand bookingCommand = new CancelCommand(new HotelBehaviour());
        return "Cancel";
    }

    @DeleteMapping("/Cancel event booking")
    public String cancelEventBooking() {
        BookingCommand bookingCommand = new CancelCommand(new EventBehaviour());
        return "Cancel";
    }
}