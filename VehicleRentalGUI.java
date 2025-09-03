import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *
 * VehicleRentalGUI
 * This class creates the main GUI for the Vehicle Rental System.
 * It sets up the JFrame, Swing components, event listeners, and the 2D drawing canvas.
 * Users can add, sort, delete, rent, and return vehicles using the interface.
 *
 */

public class VehicleRentalGUI {
    private JFrame frame;
    private VehicleCanvas canvas;
    private JButton addButton, sortButton, deleteButton;
    private JTextField makeField, modelField, yearField, extraField;
    private JComboBox<String> typeBox;
    private JCheckBox rentedFilterCheckBox;
    private JLabel statusLabel, extraFieldLabel;
    private VehicleInventory inventory;
    private Vehicle selectedVehicle;

    // Constructor for VehicleRentalGUI.    
    public VehicleRentalGUI() {
        inventory = new VehicleInventory();

        frame = new JFrame("Vehicle Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 600);

        // Canvas for drawing vehicles
        canvas = new VehicleCanvas(
            () -> inventory.getAllVehicles(),
            () -> rentedFilterCheckBox.isSelected(),
            () -> selectedVehicle
        );

        // Control panel with input fields and buttons
        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        makeField = new JTextField(7);
        modelField = new JTextField(11);
        yearField = new JTextField(4);
        typeBox = new JComboBox<>(new String[] { "Car", "Boat", "Plane" });
        extraFieldLabel = new JLabel("Seats:");
        extraField = new JTextField(7);
        addButton = new JButton("Add Vehicle");
        sortButton = new JButton("Sort by Rate");
        deleteButton = new JButton("Delete Vehicle");
        rentedFilterCheckBox = new JCheckBox("Show Rented Only");
        statusLabel = new JLabel("Status: Ready");

        int row = 0;
        gbc.gridy = row;
        gbc.gridx = 0; controlPanel.add(new JLabel("Make:"), gbc);
        gbc.gridx = 1; controlPanel.add(makeField, gbc);
        gbc.gridx = 2; controlPanel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 3; controlPanel.add(modelField, gbc);
        gbc.gridx = 4; controlPanel.add(new JLabel("Year:"), gbc);
        gbc.gridx = 5; controlPanel.add(yearField, gbc);

        row++;
        gbc.gridy = row;
        gbc.gridx = 0; controlPanel.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1; controlPanel.add(typeBox, gbc);
        gbc.gridx = 2; controlPanel.add(extraFieldLabel, gbc);
        gbc.gridx = 3; controlPanel.add(extraField, gbc);
        gbc.gridx = 4; controlPanel.add(addButton, gbc);
        gbc.gridx = 5; controlPanel.add(deleteButton, gbc);

        row++;
        gbc.gridy = row;
        gbc.gridx = 0; controlPanel.add(sortButton, gbc);
        gbc.gridx = 1; controlPanel.add(rentedFilterCheckBox, gbc);

        JLabel titleLabel = new JLabel("Vehicle Rental System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel("Add, rent, sort, and manage different types of vehicles.", SwingConstants.CENTER);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(titleLabel);
        topPanel.add(descLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(controlPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);

        setupListeners();

        frame.setVisible(true);
    }

    // The setupListeners attaches all event listeners to the Swing components and canvas.
    
    private void setupListeners() {
        // Update extra field label based on vehicle type selection
        typeBox.addActionListener(e -> {
            String type = (String) typeBox.getSelectedItem();
            switch (type) {
                case "Car": extraFieldLabel.setText("Seats:"); break;
                case "Boat": extraFieldLabel.setText("Length (ft):"); break;
                case "Plane": extraFieldLabel.setText("Engines:"); break;
            }
        });

        // Add vehicle button
        addButton.addActionListener(e -> {
            try {
                String make = makeField.getText().trim();
                String model = modelField.getText().trim();
                int year = Integer.parseInt(yearField.getText().trim());
                String type = (String) typeBox.getSelectedItem();
                String extra = extraField.getText().trim();

                if (make.isEmpty() || model.isEmpty() || extra.isEmpty()) {
                    statusLabel.setText("Error: Make, Model, and Extra Field are required.");
                    return;
                }

                Vehicle v;
                if ("Car".equals(type)) {
                    int seats = Integer.parseInt(extra);
                    v = new Car(make, model, year, seats);
                } else if ("Boat".equals(type)) {
                    double length = Double.parseDouble(extra);
                    v = new Boat(make, model, year, length);
                } else {
                    int engines = Integer.parseInt(extra);
                    v = new Plane(make, model, year, engines, false);
                }

                inventory.addVehicle(v);
                statusLabel.setText("Added: " + v);
                selectedVehicle = null;
                canvas.repaint();
            } catch (NumberFormatException ex) {
                statusLabel.setText("Error: Invalid number format.");
            }
        });

        // Sort vehicles by rate
        sortButton.addActionListener(e -> {
            inventory.sortInventoryByRate();
            statusLabel.setText("Inventory sorted by rental rate.");
            canvas.repaint();
        });

        // Delete selected vehicle
        deleteButton.addActionListener(e -> {
            if (selectedVehicle != null) {
                inventory.removeVehicle(selectedVehicle);
                statusLabel.setText("Deleted: " + selectedVehicle);
                selectedVehicle = null;
                canvas.repaint();
            } else {
                statusLabel.setText("No vehicle selected to delete.");
            }
        });

        // Filter rented vehicles
        rentedFilterCheckBox.addActionListener(e -> {
            if (rentedFilterCheckBox.isSelected()) {
                statusLabel.setText("Filtering: Showing rented vehicles only.");
            } else {
                statusLabel.setText("Showing all vehicles.");
            }
            selectedVehicle = null;
            canvas.repaint();
        });

        // Mouse listener for renting/returning vehicles by clicking on them
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int y = 30;
                int cardWidth = 500;
                int cardHeight = 90;
                int cardX = 50;

                boolean found = false;

                for (Vehicle v : inventory.getAllVehicles()) {
                    if (rentedFilterCheckBox.isSelected() && !v.isRented()) {
                        y += cardHeight + 20;
                        continue;
                    }

                    Rectangle cardRect = new Rectangle(cardX, y, cardWidth, cardHeight);
                    if (cardRect.contains(e.getPoint())) {
                        selectedVehicle = v;

                        if (v.isRented()) {
                            v.returns();
                            statusLabel.setText("Returned: " + v);
                        } else {
                            v.rent();
                            statusLabel.setText("Rented: " + v);
                        }

                        found = true;
                        canvas.repaint();
                        break;
                    }
                    y += cardHeight + 20;
                }

                if (!found) {
                    selectedVehicle = null;
                    statusLabel.setText("No vehicle selected.");
                    canvas.repaint();
                }
            }
        });
    }
}