# Hotel and Event Booking API


A robust and scalable API for managing hotel and event bookings. This API allows users to register, log in, book hotel rooms, and schedule events efficiently. Built with Spring Boot, it incorporates best practices for security, scalability, and ease of use.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Endpoints](#endpoints)
- [Team Information](#team-information)
- [Contact](#contact)


---

## Features
- **User Management**:  
  Register, log in, update profiles, and delete accounts.
- **Booking Management**:  
  Book hotel rooms, schedule events, and manage reservations.
- **Authentication**:  
  Secure token-based authentication using JWT.
- **CRUD Operations**:  
  Full support for Create, Read, Update, and Delete operations.
- **Validation**:  
  Validates user input and ensures data integrity.

---

## Technologies
- **Backend**: Java, Spring Boot
- **Security**: JWT Authentication, Spring Security
- **Build Tool**: Maven
- **Testing**: JUnit

---

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Kareemahmed2/SDAProject.git
   cd SDAProject
   
2. Configure the database:
   Update the application.properties file with your database credentials.

3. Build the project:
   ```bash
   mvn clean install
4. Run the application:
   ```bash
     mvn spring-boot:run
5. Access the API:
   ```bash
    Navigate to http://localhost:8080.
   
## EndPoints
### **User Endpoints (/user)**
| HTTP Method | Endpoint       | Description                     |
|-------------|----------------|---------------------------------|
| POST        | `/register`    | Register a new user             |
| POST        | `/login`       | Authenticate and retrieve a token |
| PUT         | `/update`      | Update user details             |
| DELETE      | `/delete/{id}` | Delete a user                   |

### **Booking Endpoints (/api)**
| HTTP Method | Endpoint          | Description          |
|-------------|-------------------|----------------------|
| POST        | `/BookHotel`      | Create a new booking |
| GET         | `/SearchHotels`   | Search for hotels    |


### **Event Endpoints (/api)**
| HTTP Method | Endpoint          | Description            |
|-------------|-------------------|------------------------|
| POST        | `/BookEvent`      | Create a new event     |
| GET         | `/SearchEvents`   | Delete an event        |


### **Dashboard Endpoints (/dashboard)**
| HTTP Method | Endpoint          | Description            |
|-------------|-------------------|------------------------|
| GET         | `/bookings`       | Print bookings for user|
| GET         | `/notifications`  | Display Notifications  |

## Team Information
- **Jana Salem**: Handled the class diagram and full implementation of the API.
- **Maya Hossam**: Handled the documentation and SRS document.
- **Kareem Ahmed**: Handled the class diagram and full implementation of the API.
- **Thomas Ahdy**: Handled the documentation and SRS document.
- **Farah Hassan**: Handled the documentation and SRS document.


## Contact
For any questions or feedback, feel free to reach out:

**Maintainer 1**: Kareem Ahmed  
**Email**: ka.mahrous@gmail.com

**Maintainer 2**: Jana Salem  
**Email**: janamohamed248@gmail.com  
