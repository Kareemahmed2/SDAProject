package com.example.demo.NotificationHandler;

import com.example.demo.Booking.BookingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SMSNotification.class, name = "SMSNotification"),
        @JsonSubTypes.Type(value = EmailNotification.class, name = "EmailNotification"),
        @JsonSubTypes.Type(value = RecommendationNotification.class, name = "RecommendationNotification")
})
public abstract class Notification {

    private String message;
    @JsonIgnore
    protected BookingRequest bookingRequest;

    public Notification() {
        this.bookingRequest = new BookingRequest(); // Default initialization
    }

    // Template method - defines the steps
    public final void CreateNotification() {
        message = generateMessage();
        logNotification(message);
    }

    protected abstract String generateMessage();

    private void logNotification(String message) {
        System.out.println("Logging notification: " + message);
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }

    public String getMessage() {
        return message;
    }
}
