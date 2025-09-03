# 🚗 Vehicle Rental System (Java + Swing GUI)

An interactive Java application that simulates a vehicle rental system.  
Originally built as a **console program** to demonstrate OOP, it has now been extended with a **graphical user interface (GUI)** using **Java Swing** and a custom drawing canvas. Users can **add, sort, rent, return, and delete vehicles** via an intuitive interface, with each vehicle displayed as a color-coded card.

---

## 📌 Description

This project demonstrates both **core object-oriented programming (OOP)** principles and **Java GUI development**.  
It integrates:
- Inheritance, polymorphism, encapsulation, and method overriding  
- Interface implementation (`Comparable`)  
- Dynamic rental rate calculation per vehicle type  
- A **2D GUI layer** with interactive mouse events, filtering, and card-style rendering  

---

## ✅ Features

### 🖥 Console Features (Base Version)
- Abstract superclass `Vehicle` with shared properties  
- Subclasses: `Car`, `Boat`, `Plane` with unique attributes  
- Rental/return system with state updates  
- Equality (`equals`), ordering (`Comparable`), and string formatting (`toString`)  
- Inventory management with `ArrayList`  

### 🎨 GUI Features (New)
- **VehicleCanvas** (custom `JPanel`) that:
  - Displays each vehicle as a **card** with color-coded status (green = available, red = rented)  
  - Highlights the selected vehicle  
  - Updates dynamically when vehicles are added, removed, or rented/returned  

- **VehicleRentalGUI** (main interface) with:  
  - Input fields for Make, Model, Year, and type-specific attributes (Seats / Length / Engines)  
  - Buttons for **Add**, **Sort by Rate**, and **Delete**  
  - Checkbox filter to show only rented vehicles  
  - Click-to-rent / click-to-return functionality  

---

## 🖼️ Screenshots

> *(Add screenshots of your GUI here, e.g. one with vehicles added and another with rented-only filter enabled)*

---

## 🛠️ Technologies Used
- **Java (JDK 8+)**
- **Swing GUI Toolkit**
- **Java 2D Graphics**
- **Collections**

---

## 🚀 Future Improvements
- Add persistent storage (save/load from file or database)  
- Support multiple rental days with billing calculation  
- Add search/filter options (by make, model, year, etc.)  
- Improve UI with JavaFX or modern libraries  
- Export rental logs/reports  

---
