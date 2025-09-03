import java.util.*;

/*
 *
 * VehicleInventory manages a list of available vehicles for rental.
 * 
 */

public class VehicleInventory {
    private List<Vehicle> vehicles;

    // Constructs an empty inventory list.
    public VehicleInventory() {
        vehicles = new ArrayList<>();
    }

    // Adds a new vehicle to the inventory.
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    // Removes a vehicle from the inventory if it exists; otherwise prints a warning
    public void removeVehicle(Vehicle v) {
        if (vehicles.contains(v)) {
            vehicles.remove(v);
        } else {
            System.out.println("Cannot remove: " + v.getYear() + " " + v.getMake() + " " + v.getModel() + " is not in the inventory.");
        }
    }

    //Attempts to rent a vehicle if it is available.
    public void rentVehicle(Vehicle v) {
        if (vehicles.contains(v) && !v.isRented()) {
            v.rent();
            System.out.println(v.getYear() + " " + v.getMake() + " " + v.getModel() + " rented.");
        } else {
            System.out.println("Vehicle not available for rent.");
        }
    }

    // Attempts to return a vehicle if it is currently rented.
    public void returnVehicle(Vehicle v) {
        if (vehicles.contains(v) && v.isRented()) {
            v.returns();
            System.out.println(v + " returned.");
        } else {
            System.out.println("Vehicle not currently rented.");
        }
    }

    // Displays all vehicles in the inventory.
    public void displayInventory() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // Sorts the vehicle inventory by rental rate in ascending order.
    // Uses Vehicle's compareTo() to sort by rental rate
    public void sortInventoryByRate() {
        Collections.sort(vehicles);
    }
}