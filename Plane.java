/*
 *
 * A Plane is a type of Vehicle with engine count and type (private/commercial).
 * 
 */

public class Plane extends Vehicle {
    private int engineCount;
    private boolean isPrivate;

    // Constructor to initialize a Plane object with make, model, year, engine count, and private status
    public Plane(String make, String model, int year, int engineCount, boolean isPrivate) {
        super(make, model, year);
        this.engineCount = engineCount;
        this.isPrivate = isPrivate;
    }

    // Getter method to get the number of engines in the plane
    public int getEngineCount() { return engineCount; }

    // Setter method to set the number of engines in the plane
    public void setEngineCount(int engineCount) { this.engineCount = engineCount; }

    // Getter method to check if the plane is private
    public boolean isPrivate() { return isPrivate; }
    public void setPrivate(boolean aPrivate) { isPrivate = aPrivate; }

    //Returns rental rate based on engine count and type.   
    @Override
    public double getRentalRate() {
        double baseRate = isPrivate ? 199.99 : 399.99;
        return baseRate + (engineCount * 50);
    }

    //Returns string representation of the plane.
    @Override
    public String toString() {
        return super.toString() + ", Engines: " + engineCount + ", Type: " + (isPrivate ? "Private" : "Commercial") + ", Rental Rate: $" + String.format("%.2f", getRentalRate());
    }
}