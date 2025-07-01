/*
 *
 * Abstract class representing a general vehicle.
 * Implements Comparable to allow sorting based on rental rate.
 * 
 */

public abstract class Vehicle implements Comparable<Vehicle> {
    private String make;
    private String model;
    private int year;
    private boolean isRented;

    // Constructor to initialize a Vehicle object.
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRented = false;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public boolean isRented() { return isRented; }

    // Marks the vehicle as rented.
    public void rent() { isRented = true; }

    // Marks the vehicle as returned.
    public void returns() { isRented = false; }

    // Abstract method to get rental rate, implemented in subclasses.
    public abstract double getRentalRate();

    // Returns a string representation of the vehicle.
    @Override
    public String toString() {
        return year + " " + make + " " + model + (isRented ? " (Rented)" : " (Available)");
    }

    // Compares two vehicles for equality based on make, model, and year.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        return make.equals(other.make) && model.equals(other.model) && year == other.year;
    }

    // Compares vehicles by their rental rate.
    @Override
    public int compareTo(Vehicle other) {
        return Double.compare(this.getRentalRate(), other.getRentalRate());
    }
}