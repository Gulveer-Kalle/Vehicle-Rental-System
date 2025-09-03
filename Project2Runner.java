public class Project2Runner {

    /*
     * Name: Gulveer Kalle
     * Student ID: 501297852
     *
     * ******** Project Description ********
     * This program implements a Vehicle Rental System GUI using Java Swing and 2D graphics.
     * Users can add vehicles (Car, Boat, Plane) by entering details and selecting the type.
     * The inventory is displayed graphically on a custom JPanel, with each vehicle shown as a colored card.
     * Users can rent or return vehicles by clicking on their cards, sort vehicles by rental rate,
     * delete vehicles, and filter to show only rented vehicles.
     *
     * The system is built with several classes:
     * - Vehicle: An abstract base class representing a generic vehicle, with fields for make, model, year, rental status, and rental rate.
     * - Car, Boat, Plane: Subclasses of Vehicle, each adding specific properties (e.g., seats for Car, length for Boat, engines for Plane).
     * - VehicleInventory: Manages a collection of Vehicle objects, providing methods to add, remove, and sort vehicles.
     * - VehicleRentalGUI: The main GUI class, which sets up the JFrame, Swing components, event listeners, and integrates the drawing canvas.
     * - VehicleCanvas: A JPanel subclass that draws all vehicles as colored cards, visually indicating rental status and selection.
     *
     * ******** How Requirements Are Met ********
     * - Swing: The GUI uses JFrame, JButton (Add, Sort, Delete), JTextField (make, model, year, extra),
     *   JComboBox (vehicle type), JCheckBox (filter), and JLabel (status, labels).
     * - 2D Graphics: VehicleCanvas extends JPanel and overrides paintComponent to draw each vehicle as a
     *   colored card, with visual cues for rental status and selection.
     * - Event Listeners: ActionListeners are attached to buttons and the filter checkbox to update the
     *   inventory and canvas. A MouseListener on the canvas allows users to rent or return vehicles by
     *   clicking on them.
     *
     * ******** Instructions ********
     * - Enter vehicle details and select a type, then click "Add Vehicle" to add to the inventory.
     * - Click "Sort by Rate" to sort vehicles by their rental rate.
     * - Click "Delete Vehicle" to remove the selected vehicle.
     * - Use the "Show Rented Only" checkbox to filter the display.
     * - Click on a vehicle card to rent or return it.
     *
     */

    public static void main(String[] args) {
        new VehicleRentalGUI();
    }
}