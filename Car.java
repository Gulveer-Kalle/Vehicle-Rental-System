/*
 *
 * A Car is a type of Vehicle that has a number of seats.
 * 
 */

public class Car extends Vehicle {
    private int seats;

    // Constructor to initialize a Car object with make, model, year, and seats
    public Car(String make, String model, int year, int seats) {
        super(make, model, year);
        this.seats = seats;
    }

    // Getter method to get the number of seats in the car
    public int getSeats() { return seats; }
    
    // Setter method to set the number of seats in the car
    public void setSeats(int seats) { this.seats = seats; }

    //Returns the rental rate for the car based on seat count.
    @Override
    public double getRentalRate() {
        return 29.99 + (seats * 1.5);
    }

    //Returns string representation of the car including seat info.
    @Override
    public String toString() {
        return super.toString() + ", Seats: " + seats + ", Rental Rate: $" + String.format("%.2f", getRentalRate());
    }
}