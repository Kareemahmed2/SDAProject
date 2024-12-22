package com.example.demo.NotificationHandler;

public class EmailNotification extends Notification {

    public EmailNotification() {
        super();
    }

    @Override
    protected String generateMessage() {
        return "Subject: Your booking has been confirmed\n\n" +
                "Dear " + bookingRequest.getUsername() + ",\n" +
                "Thank you for booking with us!\n" +
                "Your booking details are as follows:\n" +
                "Booking institution: " + bookingRequest.getName() + "\n" +
                "We look forward to hosting you.\n" +
                "Best regards,\n" +
                "bookly team";
    }
}
