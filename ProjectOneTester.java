/*
 * CPS 209 – Project 1
 * Name: Gulveer Kalle
 * Student ID: 501297852
 * 
 * Problem Overview:
 * This project is a vehicle rental system that manages different types of vehicles like cars, boats,
 * and planes using an object-oriented programming. It allows vehicles to be added, removed, rented, returned,
 * and displayed, with each type defining its own rental rate logic and other specific attributes. 
 * Inheritance is used to share common features across vehicle types, and polymorphism enables each subclass 
 * to override behavior like rental rate calculation and string representation. The system uses private fields
 * with public getters and setters, and all classes have constructors in them. 
 * The `Vehicle` class implements the `Comparable` interface which allows sorting by rental rate, and `ArrayList` 
 * is used to manage and store the vehicle inventory. Overridden methods like `toString()` and `equals()` ensure
 * clear output and object comparison. The main method demonstrates all functionality, including edge cases.
 *
 * This class serves as the entry point for demonstrating the functionality 
 * of the Vehicle Rental System.
 * 
 */

public class ProjectOneTester {
    public static void main(String[] args) {

        // Initialize the vehicle inventory
        VehicleInventory inventory = new VehicleInventory();

        // Create vehicle objects
        Vehicle car1 = new Car("Toyota", "Corolla", 2022, 5);
        Vehicle car2 = new Car("Honda", "Civic", 2021, 4);
        Vehicle boat1 = new Boat("Yamaha", "212X", 2023, 21.3);
        Vehicle plane1 = new Plane("Boeing", "737", 2018, 2, false);
        Vehicle plane2 = new Plane("Cessna", "172", 2022, 1, true);

        // Add vehicles to the inventory
        inventory.addVehicle(car1);
        inventory.addVehicle(car2);
        inventory.addVehicle(boat1);
        inventory.addVehicle(plane1);
        inventory.addVehicle(plane2);

        // Display the initial inventory
        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Renting a vehicle
        System.out.println("\nRenting Honda Civic:");
        inventory.rentVehicle(car2);

        // Display inventory after rental
        System.out.println("\nInventory After Rental:");
        inventory.displayInventory();

        // Returning the rented vehicle
        System.out.println("\nReturning Honda Civic:");
        inventory.returnVehicle(car2);

        // Demonstrating updates to vehicle attributes
        System.out.println("\nDemonstrating updates:");
        ((Car) car1).setSeats(6);
        ((Boat) boat1).setLength(24.5);
        ((Plane) plane1).setEngineCount(3);
        ((Plane) plane2).setPrivate(false);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();

        // equals() demonstration
        System.out.println("\nTesting equals method:");
        Vehicle testCar = new Car("Toyota", "Corolla", 2022, 5);
        System.out.println("car1 equals testCar? " + car1.equals(testCar));
        System.out.println("car1 == testCar? " + (car1 == testCar));

        // Sorting demonstration
        System.out.println("\nInventory Sorted by Rental Rate:");
        inventory.sortInventoryByRate();
        inventory.displayInventory();

        // Edge case: renting an already rented vehicle
        System.out.println("\nTrying to rent already rented car:");
        inventory.rentVehicle(car2);
        inventory.rentVehicle(car2);

        // Edge case: returning an available vehicle
        System.out.println("\nTrying to return an available car:");
        inventory.returnVehicle(car1);

        // Removing a vehicle from the inventory
        System.out.println("\nRemoving Boat from Inventory:");
        inventory.removeVehicle(boat1);

        // Display inventory after removal
        System.out.println("\nInventory After Removing Boat:");
        inventory.displayInventory();

        // Edge case: trying to remove a vehicle not in the inventory
        System.out.println("\nTrying to remove a non-existent vehicle:");
        Vehicle ghostCar = new Car("Ford", "Focus", 2019, 4);
        inventory.removeVehicle(ghostCar);
    }
}