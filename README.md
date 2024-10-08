
# Hotel Management System

## Overview
This is a Hotel Management System built using **JavaFX** for the frontend and **MySQL** as the database. It is designed to streamline the operations of a hotel by providing separate control panels for the admin, receptionist, and guests. Each panel has distinct functionalities suited for its role, and the system is highly customizable for hotel operations like room allocation, guest management, and room service.

## Features
- **Admin Panel:**
  - Manage receptionist information (add, update, delete).
  - Oversee room details (availability, management).
  - Control guest and room service data.
  
- **Receptionist Panel:**
  - Handle guest check-ins and check-outs.
  - Manage room service requests and updates.
  - View and update room availability.

- **Guest Panel:**
  - View room and personal details, including check-in/check-out status.
  - Place and track room service orders.
  
## Database Structure
- **Admin Table**: Stores admin data.
- **Guest Table**: Contains guest information, including their stay details.
- **Receptionist Table**: Manages receptionist information.
- **Rooms Table**: Tracks room availability, room IDs, and associated guest details.
- **Orders Table**: Stores information about room service orders, linked to rooms and guests.

## Software & Technologies
- **JavaFX**: For the graphical user interface.
- **MySQL**: As the database management system.
- **SceneBuilder**: For designing the UI components.
- **IntelliJ IDEA**: The integrated development environment (IDE) used for building the project.

## Panels Breakdown

### Admin Panel
The admin has full access to manage room data, receptionist information, and guest-related operations:
- Insert, update, and delete room or receptionist data.
- Manage guest data with search and filter functionalities.

### Receptionist Panel
Designed for handling guest services:
- Room availability check and guest allocation for check-ins and check-outs.
- Room service management including order tracking and updates.

### Guest Panel
The guest can log in to view personal details, room service options, and manage orders:
- Dynamic selection of room service items with real-time cost updates.
- Order tracking and editing options for existing orders.

## How to Run
1. Install JavaFX and MySQL on your machine.
2. Clone this repository:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```
3. Open the project in **IntelliJ IDEA** and configure your MySQL connection details.
4. Run the project to launch the hotel management system interface.

## Future Enhancements
- Extend the guest panel to include payment options.
- Implement an automated reporting system for the admin to track performance metrics.
- Add user authentication for increased security.

## Author
Developed by **Saugata Roy Arghya**.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
