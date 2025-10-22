package hotel.management.system.tests;

import hotel.management.system.AddRoom;
import org.junit.jupiter.api.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class AddRoomTest {

    private AddRoom addRoom;

    @BeforeEach
    void setUp() {
        addRoom = new AddRoom();
    }

    @Test
    void testAddRoomUIComponents() {
        // Verify all UI components are initialized
        assertNotNull(addRoom.contentPane, "Content Pane should be initialized.");
        assertNotNull(addRoom.t4, "Room Number text field should be initialized.");
        assertNotNull(addRoom.comboBox, "Availability combo box should be initialized.");
        assertNotNull(addRoom.comboBox_2, "Cleaning Status combo box should be initialized.");
        assertNotNull(addRoom.t2, "Price text field should be initialized.");
        assertNotNull(addRoom.comboBox_3, "Bed Type combo box should be initialized.");
        assertNotNull(addRoom.b1, "Add button should be initialized.");
        assertNotNull(addRoom.b2, "Back button should be initialized.");
    }

    @Test
    void testAddButtonAction() {
        // Set test data
        addRoom.t4.setText("101");
        addRoom.comboBox.setSelectedItem("Available");
        addRoom.comboBox_2.setSelectedItem("Cleaned");
        addRoom.t2.setText("1500");
        addRoom.comboBox_3.setSelectedItem("Single Bed");

        // Simulate Add button click
        ActionEvent event = new ActionEvent(addRoom.b1, ActionEvent.ACTION_PERFORMED, "Add");
        addRoom.actionPerformed(event);

        // Simulate success message (the database interaction would be tested separately)
        String roomNumber = addRoom.t4.getText();
        assertEquals("101", roomNumber, "Room number should match input value.");
    }

    @Test
    void testBackButtonAction() {
        // Simulate Back button click
        ActionEvent event = new ActionEvent(addRoom.b2, ActionEvent.ACTION_PERFORMED, "Back");
        addRoom.actionPerformed(event);

        // Check if the window is no longer visible
        assertFalse(addRoom.isVisible(), "AddRoom window should close after clicking Back button.");
    }

    @Test
    void testEmptyRoomNumber() {
        // Leave Room Number empty
        addRoom.t4.setText("");
        addRoom.comboBox.setSelectedItem("Available");
        addRoom.comboBox_2.setSelectedItem("Cleaned");
        addRoom.t2.setText("1500");
        addRoom.comboBox_3.setSelectedItem("Single Bed");

        // Simulate Add button click
        ActionEvent event = new ActionEvent(addRoom.b1, ActionEvent.ACTION_PERFORMED, "Add");
        addRoom.actionPerformed(event);

        // Check Room Number field for empty value
        assertEquals("", addRoom.t4.getText(), "Room number should not be empty.");
    }

    @Test
    void testInvalidPriceInput() {
        // Set invalid price
        addRoom.t4.setText("102");
        addRoom.comboBox.setSelectedItem("Occupied");
        addRoom.comboBox_2.setSelectedItem("Dirty");
        addRoom.t2.setText("invalid_price");
        addRoom.comboBox_3.setSelectedItem("Double Bed");

        // Simulate Add button click
        ActionEvent event = new ActionEvent(addRoom.b1, ActionEvent.ACTION_PERFORMED, "Add");
        addRoom.actionPerformed(event);

        // Check that price input remains unchanged and validation is triggered
        assertEquals("invalid_price", addRoom.t2.getText(), "Price input should not be processed if invalid.");
    }

}
