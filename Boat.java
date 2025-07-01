/*
 *
 * A Boat is a type of Vehicle that has a specific length.
 * 
 */

public class Boat extends Vehicle {
    private double length;

    // Constructor to initialize a Boat object with make, model, year, and length
    public Boat(String make, String model, int year, double length) {
        super(make, model, year);
        this.length = length;
    }

    // Getter method to get the length of the boat
    public double getLength() { return length; }

    // Setter method to set the length of the boat
    public void setLength(double length) { this.length = length; }

    //Returns rental rate for the boat based on length.
    @Override
    public double getRentalRate() {
        return 59.99 + (length * 0.5);
    }

    //Returns string representation of the boat including length.  
    @Override
    public String toString() {
        return super.toString() + ", Length: " + length + "ft" + ", Rental Rate: $" + String.format("%.2f", getRentalRate());
    }
}