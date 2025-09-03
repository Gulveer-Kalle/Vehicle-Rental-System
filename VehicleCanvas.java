import java.awt.*;
import java.util.function.Supplier;
import javax.swing.*;

/*
 *
 * VehicleCanvas
 * This JPanel subclass acts as the drawing canvas for the Vehicle Rental System.
 * It visually displays all vehicles as cards, showing their details and rental status.
 * The canvas updates when vehicles are added, removed, rented, or returned.
 * 
 */

public class VehicleCanvas extends JPanel {
    private Supplier<Iterable<Vehicle>> vehicleSupplier;
    private Supplier<Boolean> rentedOnlySupplier;
    private Supplier<Vehicle> selectedSupplier;

    // VehicleCanvas constructor
    public VehicleCanvas(Supplier<Iterable<Vehicle>> vehicleSupplier,
                         Supplier<Boolean> rentedOnlySupplier,
                         Supplier<Vehicle> selectedSupplier) {
        this.vehicleSupplier = vehicleSupplier;
        this.rentedOnlySupplier = rentedOnlySupplier;
        this.selectedSupplier = selectedSupplier;
        setBackground(new Color(245, 245, 245));
    }

    // The paintComponent draws all vehicle cards on the canvas, including their details and rental status.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int y = 30;
        int cardWidth = 500;
        int cardHeight = 90;
        int cardX = 50;

        for (Vehicle v : vehicleSupplier.get()) {
            if (rentedOnlySupplier.get() && !v.isRented()) {
                continue;
            }

            // Draw card background
            Color bgColor = v.isRented() ? new Color(255, 230, 230) : new Color(230, 255, 230);
            g2.setColor(bgColor);
            g2.fillRoundRect(cardX, y, cardWidth, cardHeight, 20, 20);

            // Draw card border
            g2.setColor(Color.DARK_GRAY);
            g2.drawRoundRect(cardX, y, cardWidth, cardHeight, 20, 20);

            // Highlight if selected
            if (v == selectedSupplier.get()) {
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(3));
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(cardX - 2, y - 2, cardWidth + 4, cardHeight + 4, 20, 20);
                g2.setStroke(oldStroke);
            }

            // Vehicle type and rental status text
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("SansSerif", Font.BOLD, 14));
            String type = v.getClass().getSimpleName();
            String rentedText = v.isRented() ? " (Rented)" : "";
            g2.drawString(type + rentedText, cardX + 15, y + 20);

            // Rental status icon
            int iconSize = 15;
            int iconX = cardX + cardWidth - 30;
            int iconY = y + 10;
            g2.setColor(v.isRented() ? Color.RED : Color.GREEN);
            g2.fillOval(iconX, iconY, iconSize, iconSize);
            g2.setColor(Color.BLACK);
            g2.drawOval(iconX, iconY, iconSize, iconSize);

            // Details line 1: Make, Model, Year
            g2.setFont(new Font("SansSerif", Font.PLAIN, 13));
            String line1 = "Make: " + v.getMake() + "    Model: " + v.getModel() + "    Year: " + v.getYear();
            g2.drawString(line1, cardX + 15, y + 40);

            // Details line 2: Specific info + Rate
            String extraInfo = "";
            if (v instanceof Car) {
                extraInfo = "Seats: " + ((Car) v).getSeats();
            } else if (v instanceof Boat) {
                extraInfo = "Length: " + ((Boat) v).getLength() + " ft";
            } else if (v instanceof Plane) {
                extraInfo = "Engines: " + ((Plane) v).getEngineCount();
            }
            String line2 = extraInfo + "    Rate: $" + String.format("%.2f", v.getRentalRate()) + "/day";
            g2.drawString(line2, cardX + 15, y + 60);

            y += cardHeight + 20;
        }
    }
}
