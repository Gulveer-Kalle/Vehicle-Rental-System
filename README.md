# 🚗 Vehicle Rental System (Java)

A console-based Java application that simulates a simple vehicle rental system. Users can add, remove, rent, and return vehicles — including cars, boats, and planes — with rental rates dynamically calculated based on vehicle-specific attributes.

## 📌 Description

This project demonstrates core object-oriented programming (OOP) concepts such as inheritance, polymorphism, encapsulation, method overriding, and interface implementation (`Comparable`). The system manages a list of vehicles using an `ArrayList` and provides sorting functionality based on rental rate.

It's designed to:
- Handle multiple vehicle types with their own attributes and rate logic
- Allow for renting/returning vehicles
- Show updates to attributes using setters
- Demonstrate `equals()`, `compareTo()`, and `toString()` overrides
- Handle edge cases like trying to rent already rented or unavailable vehicles

## ✅ Features

- Abstract superclass `Vehicle` with shared properties and behavior
- Subclasses: `Car`, `Boat`, and `Plane` with specific attributes:
  - Car → seats
  - Boat → length
  - Plane → engine count and private/commercial type
- Dynamic rental rate calculation based on vehicle type and attributes
- Vehicle comparison using `Comparable` (by rental rate)
- Full inventory management: add, remove, rent, return, display
- Object equality check with `equals()`
- Clear and consistent `toString()` output for each vehicle type
- Console output demonstrating all functionalities and edge cases

## 🖥️ Sample Output

```
Initial Inventory:
2022 Toyota Corolla (Available), Seats: 5, Rental Rate: $37.49
2021 Honda Civic (Available), Seats: 4, Rental Rate: $35.99
2023 Yamaha 212X (Available), Length: 21.3ft, Rental Rate: $70.64
2018 Boeing 737 (Available), Engines: 2, Type: Commercial, Rental Rate: $499.99
2022 Cessna 172 (Available), Engines: 1, Type: Private, Rental Rate: $249.99

Renting Honda Civic:
2021 Honda Civic rented.

Inventory After Rental:
2022 Toyota Corolla (Available), Seats: 5, Rental Rate: $37.49
2021 Honda Civic (Rented), Seats: 4, Rental Rate: $35.99
2023 Yamaha 212X (Available), Length: 21.3ft, Rental Rate: $70.64
2018 Boeing 737 (Available), Engines: 2, Type: Commercial, Rental Rate: $499.99
2022 Cessna 172 (Available), Engines: 1, Type: Private, Rental Rate: $249.99

Returning Honda Civic:
2021 Honda Civic (Available), Seats: 4, Rental Rate: $35.99 returned.

Demonstrating updates:

Updated Inventory:
2022 Toyota Corolla (Available), Seats: 6, Rental Rate: $38.99
2021 Honda Civic (Available), Seats: 4, Rental Rate: $35.99
2023 Yamaha 212X (Available), Length: 24.5ft, Rental Rate: $72.24
2018 Boeing 737 (Available), Engines: 3, Type: Commercial, Rental Rate: $549.99
2022 Cessna 172 (Available), Engines: 1, Type: Commercial, Rental Rate: $449.99

Testing equals method:
car1 equals testCar? true
car1 == testCar? false

Inventory Sorted by Rental Rate:
2021 Honda Civic (Available), Seats: 4, Rental Rate: $35.99
2022 Toyota Corolla (Available), Seats: 6, Rental Rate: $38.99
2023 Yamaha 212X (Available), Length: 24.5ft, Rental Rate: $72.24
2022 Cessna 172 (Available), Engines: 1, Type: Commercial, Rental Rate: $449.99
2018 Boeing 737 (Available), Engines: 3, Type: Commercial, Rental Rate: $549.99

Trying to rent already rented car:
2021 Honda Civic rented.
Vehicle not available for rent.

Trying to return an available car:
Vehicle not currently rented.

Removing Boat from Inventory:

Inventory After Removing Boat:
2021 Honda Civic (Rented), Seats: 4, Rental Rate: $35.99
2022 Toyota Corolla (Available), Seats: 6, Rental Rate: $38.99
2022 Cessna 172 (Available), Engines: 1, Type: Commercial, Rental Rate: $449.99
2018 Boeing 737 (Available), Engines: 3, Type: Commercial, Rental Rate: $549.99

Trying to remove a non-existent vehicle:
Cannot remove: 2019 Ford Focus is not in the inventory.
```

## 🛠️ Technologies Used

- Java (JDK 8+)
- OOP (Inheritance, Polymorphism, Interfaces)
- Collections (`ArrayList`, `Collections.sort`)
- Terminal/Console for interaction

## 🚀 Future Improvements

- Add user input/menu-based interaction
- Support saving/loading inventory from a file
- Add UI using JavaFX or Swing
- Integrate filtering/searching for vehicles
- Track rental duration and billing
