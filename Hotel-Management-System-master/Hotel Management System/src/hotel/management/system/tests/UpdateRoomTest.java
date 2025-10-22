package hotel.management.system.tests;

import hotel.management.system.UpdateRoom;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

class UpdateRoomTest {

    private UpdateRoom updateRoom;

    @BeforeEach
    void setUp() throws SQLException {
        updateRoom = new UpdateRoom();  // Initializes the UpdateRoom frame
        updateRoom.setVisible(false); // Hide the frame during tests
    }

    @AfterEach
    void tearDown() {
        updateRoom.dispose(); // Dispose the frame after each test
    }

    @Test
    void testFrameInitialization() {
        assertEquals(1000, updateRoom.getWidth(), "Frame width should be 1000");
        assertEquals(450, updateRoom.getHeight(), "Frame height should be 450");
        assertNotNull(updateRoom.getContentPane(), "Content pane should not be null");
    }

    @Test
    void testLabelInitialization() {
        // Check that the label "Update Room Status" is properly initialized
        JLabel lblUpdateRoomStatus = (JLabel) findComponent(updateRoom, JLabel.class, "Update Room Status");
        assertNotNull(lblUpdateRoomStatus, "Label 'Update Room Status' should be initialized");
        assertEquals("Update Room Status", lblUpdateRoomStatus.getText(), "Label text should be 'Update Room Status'");
    }

    @Test
    void testTextFieldInitialization() {
        // Ensure that the text fields for room number, availability, and clean status are properly initialized
        assertNotNull(updateRoom.txt_Room, "Text field for room number should be initialized");
        assertNotNull(updateRoom.txt_Ava, "Text field for availability should be initialized");
        assertNotNull(updateRoom.txt_Status, "Text field for clean status should be initialized");
    }

    @Test
    void testChoiceInitialization() {
        // Test that the Choice component (Guest ID dropdown) is properly initialized
        assertNotNull(updateRoom.c1, "Choice for Guest ID should be initialized");
    }

    @Test
    void testButtonCheckAction() {
        // Simulate clicking the "Check" button and verify if room details are populated
        JButton btnCheck = (JButton) findComponent(updateRoom, JButton.class, "Check");
        assertNotNull(btnCheck, "Button 'Check' should be initialized");

        // Simulate button click
        assertDoesNotThrow(() -> btnCheck.doClick(), "Button 'Check' should not throw exceptions");

        // Verify if the room number field is populated after button click (you may set mock database if needed for full tests)
        assertFalse(updateRoom.txt_Room.getText().isEmpty(), "Room number should be populated after Check button click");
    }

    @Test
    void testUpdateButtonAction() {
        // Simulate clicking the "Update" button and verify if the update message appears
        JButton btnUpdate = (JButton) findComponent(updateRoom, JButton.class, "Update");
        assertNotNull(btnUpdate, "Button 'Update' should be initialized");

        // Set sample data to text fields
        updateRoom.txt_Room.setText("101");
        updateRoom.txt_Status.setText("Clean");

        // Simulate button click
        assertDoesNotThrow(() -> btnUpdate.doClick(), "Button 'Update' should not throw exceptions");

        // Check that the update message appears (you can check via JOptionPane or by further mocking logic if needed)
        // Since we can't verify JOptionPane directly, we assume the execution does not throw exceptions
    }

    @Test
    void testBackButtonAction() {
        // Simulate clicking the "Back" button and verify that the Reception screen appears
        JButton btnBack = (JButton) findComponent(updateRoom, JButton.class, "Back");
        assertNotNull(btnBack, "Button 'Back' should be initialized");

        // Simulate button click
        assertDoesNotThrow(() -> btnBack.doClick(), "Button 'Back' should not throw exceptions");

        // Check that a new Reception frame appears after clicking "Back" (indirect test)
    }

    @Test
    void testRoomNumberLabelInitialization() {
        // Check that the "Room Number" label is properly initialized
        JLabel lblRoomId = (JLabel) findComponent(updateRoom, JLabel.class, "Room Number:");
        assertNotNull(lblRoomId, "Label 'Room Number' should be initialized");
        assertEquals("Room Number:", lblRoomId.getText(), "Label text should be 'Room Number:'");
    }

    @Test
    void testWindowClose() {
        // Test the window close method
        assertDoesNotThrow(() -> updateRoom.close(), "Close method should not throw exceptions");
    }

    private Component findComponent(JFrame frame, Class<?> componentClass, String text) {
        for (Component component : frame.getContentPane().getComponents()) {
            if (componentClass.isInstance(component)) {
                if (component instanceof JLabel) {
                    JLabel label = (JLabel) component;
                    if (label.getText() != null && label.getText().equals(text)) {
                        return component;
                    }
                }
            }
        }
        return null; // Return null if no matching component is found
    }

}
