package com.example.demo.NotificationHandler;

public class SMSNotification extends Notification {

    public SMSNotification() {
        super();
    }

    @Override
    protected String generateMessage() {
        return "Hi " + bookingRequest.getUsername() + ", the booking request " +
                "for " + bookingRequest.getName() +
                " has been confirmed. Thank you for choosing us!";
    }
}
