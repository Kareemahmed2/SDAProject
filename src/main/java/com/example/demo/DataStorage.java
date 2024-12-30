package com.example.demo;

import com.example.demo.Booking.*;
import com.example.demo.NotificationHandler.Notification;
import com.example.demo.UserManagement.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DataStorage {

    private static final String USERS_FILE = "users.json";
    private static final String HOTELS_FILE = "hotels.json";
    private static final String EVENTS_FILE = "events.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();// Load data from files
    @PostConstruct
    public static void init() {
        objectMapper.registerModule(new JavaTimeModule());
        generateData();
    }
    public static List<User> loadUsers() {
        return readFromFile(USERS_FILE, new TypeReference<List<User>>() {});
    }

    public static List<Hotel> loadHotels() {
        return readFromFile(HOTELS_FILE, new TypeReference<List<Hotel>>() {});
    }

    public static List<Event> loadEvents() {
        return readFromFile(EVENTS_FILE, new TypeReference<List<Event>>() {});
    }

    // Save data to files
    public static void saveUsers(List<User> users) {
        writeToFile(USERS_FILE, users);
    }

    public static void saveHotels(List<Hotel> hotels) {
        writeToFile(HOTELS_FILE, hotels);
    }

    public static void saveEvents(List<Event> events) {
        writeToFile(EVENTS_FILE, events);
    }

    // Add and save methods
    public static void addUser(User user) {
        List<User> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }
    public static Boolean updateUser(User user){
        List<User> users=loadUsers();
        User userToBeUpdated=users.stream().filter(u->u.getUsername().equals(user.getUsername())).findFirst().orElse(null);
        if(userToBeUpdated!=null){
            userToBeUpdated.setUsername(user.getUsername());
            userToBeUpdated.setPassword(user.getPassword());
            userToBeUpdated.setEmail(user.getEmail());
            userToBeUpdated.setAge(user.getAge());
            saveUsers(users);
            return true;
        }
        return false;
    }

    public static Boolean validateUser(String username, String password){
        List<User> users=loadUsers();
        User user=users.stream().filter(u->u.getUsername().equals(username)).findFirst().orElse(null);
        if(user!=null){
            return user.getPassword().equals(password);
        }
        return false;
    }

    public static void addHotel(Hotel hotel) {
        List<Hotel> hotels = loadHotels();
        hotels.add(hotel);
        saveHotels(hotels);
    }

    public static void addEvent(Event event) {
        List<Event> events = loadEvents();
        events.add(event);
        saveEvents(events);
    }

    public static void addBooking(String username, Booking booking) {
        List<User> users = loadUsers();
        users.stream().filter(user -> user.getUsername().equals(username)).findFirst().ifPresent(user -> user.AddBooking(booking));
        saveUsers(users);
    }
    public static void addNotification(String username, Notification notification) {
        List<User> users = loadUsers();
        users.stream().filter(user -> user.getUsername().equals(username)).findFirst().ifPresent(user -> user.AddNotification(notification));
        saveUsers(users);
    }

    public static User getUserByUsername(String username) {
        return loadUsers().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }

    public static Hotel getHotelByName(String name) {
        return loadHotels().stream()
                .filter(hotel -> hotel.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static Event getEventByName(String name) {
        return loadEvents().stream()
                .filter(event -> event.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static List<Hotel> searchHotels(SearchingCriteria searchingCriteria) {
        List<Hotel> hotels = loadHotels().stream()
                .filter(hotel ->
                        (searchingCriteria.getName() == null || hotel.getName().equals(searchingCriteria.getName()))
                        && (searchingCriteria.getLocation() == null || hotel.getLocation().equals(searchingCriteria.getLocation())))
                .toList();
        if(hotels==loadHotels())
            return null;
        return hotels;
    }
    public static List<Event> searchEvents(SearchingCriteria searchingCriteria) {
        List<Event> events = loadEvents().stream()
                .filter(event ->
                        (searchingCriteria.getName() == null || Objects.equals(event.getName(), searchingCriteria.getName()))
                        && (searchingCriteria.getLocation() == null || Objects.equals(event.getLocation(), searchingCriteria.getLocation()))
                        && (searchingCriteria.getDate() == null || Objects.equals(event.getStartDate(), searchingCriteria.getDate()))).toList();
        if(events==loadEvents())
            return null;
        return events;
    }

    // File reading and writing utilities
    private static <T> List<T> readFromFile(String fileName, TypeReference<List<T>> typeReference) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return new ArrayList<>(); // Return empty list if file does not exist
            }
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file: " + fileName, e);
        }
    }

    private static <T> void writeToFile(String fileName, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + fileName, e);
        }
    }

    // Generate initial data
    public static void generateData() {
        if (!new File(USERS_FILE).exists() || !new File(HOTELS_FILE).exists() || !new File(EVENTS_FILE).exists()) {

            // Users

            addUser(new User("admin", "admin", "admin", 19));
            addUser(new User("user", "user", "user", 21));

            // Hotels
            Hotel hotel1 = new Hotel("Hotel 1", "Cairo", "This is Hotel 1");
            hotel1.addRoom(new Room("single", 2, 100.0));
            hotel1.addRoom(new Room("double", 3, 150.0));
            addHotel(hotel1);

            Hotel hotel2 = new Hotel("Hotel 2", "Cairo", "This is Hotel 2");
            hotel2.addRoom(new Room("family", 1, 250.0));
            addHotel(hotel2);


            // Events
            addEvent(new Event(LocalDate.parse("2024-01-01"), LocalDate.parse("2024-01-02"), "Concert", "Music event", "Opera House",120));
            addEvent(new Event(LocalDate.parse("2024-02-01"), LocalDate.parse("2024-02-02"), "Exhibition", "Art event", "Art Gallery",50));
        }
    }

    public static boolean deleteUser(String username) {
        List<User> users = loadUsers();
        if(users.removeIf(user -> user.getUsername().equals(username))){
            saveUsers(users);
            return true;
        }
        return false;
    }
}
