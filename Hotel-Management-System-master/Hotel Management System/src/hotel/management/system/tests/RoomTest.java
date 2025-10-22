package hotel.management.system.tests;

import hotel.management.system.Room;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() throws Exception {
        room = new Room();
        room.setVisible(false); // Prevent UI from rendering during tests
    }

    @AfterEach
    void tearDown() {
        room.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(1100, room.getWidth(), "Frame width should be 1100");
        assertEquals(600, room.getHeight(), "Frame height should be 600");
        assertEquals(null, room.getLayout(), "Layout should be null");
    }

    @Test
    void testTableInitialization() {
        JTable table = null;
        for (Component component : room.getContentPane().getComponents()) {
            if (component instanceof JTable) {
                table = (JTable) component;
                break;
            }
        }

        assertNotNull(table, "Table should be initialized");
        assertEquals(0, table.getX(), "Table x-coordinate should be 0");
        assertEquals(40, table.getY(), "Table y-coordinate should be 40");
        assertEquals(500, table.getWidth(), "Table width should be 500");
        assertEquals(400, table.getHeight(), "Table height should be 400");
    }

    @Test
    void testButtonInitialization() {
        JButton loadDataButton = null;
        JButton backButton = null;

        // Iterate over components to find buttons
        for (Component component : room.getContentPane().getComponents()) {
            if (component instanceof JButton button) {
                if (button.getText().equals("Load Data")) {
                    loadDataButton = button;
                } else if (button.getText().equals("Back")) {
                    backButton = button;
                }
            }
        }

        // Check Load Data button
        assertNotNull(loadDataButton, "Load Data button should be initialized");
        assertEquals("Load Data", loadDataButton.getText(), "Load Data button text should be 'Load Data'");
        assertEquals(100, loadDataButton.getX(), "Load Data button x-coordinate should be 100");
        assertEquals(470, loadDataButton.getY(), "Load Data button y-coordinate should be 470");
        assertEquals(120, loadDataButton.getWidth(), "Load Data button width should be 120");
        assertEquals(30, loadDataButton.getHeight(), "Load Data button height should be 30");

        // Check Back button
        assertNotNull(backButton, "Back button should be initialized");
        assertEquals("Back", backButton.getText(), "Back button text should be 'Back'");
        assertEquals(290, backButton.getX(), "Back button x-coordinate should be 290");
        assertEquals(470, backButton.getY(), "Back button y-coordinate should be 470");
        assertEquals(120, backButton.getWidth(), "Back button width should be 120");
        assertEquals(30, backButton.getHeight(), "Back button height should be 30");
    }


    @Test
    void testLabelInitialization() {
        JLabel availabilityLabel = room.lblAvailability;
        JLabel cleanStatusLabel = room.lblCleanStatus;
        JLabel priceLabel = room.lblNewLabel;
        JLabel bedTypeLabel = room.lblNewLabel_1;
        JLabel roomNumberLabel = room.lblId;

        assertNotNull(availabilityLabel, "Availability label should be initialized");
        assertEquals("Availability", availabilityLabel.getText(), "Availability label text should be 'Availability'");

        assertNotNull(cleanStatusLabel, "Clean Status label should be initialized");
        assertEquals("Clean Status", cleanStatusLabel.getText(), "Clean Status label text should be 'Clean Status'");

        assertNotNull(priceLabel, "Price label should be initialized");
        assertEquals("Price", priceLabel.getText(), "Price label text should be 'Price'");

        assertNotNull(bedTypeLabel, "Bed Type label should be initialized");
        assertEquals("Bed Type", bedTypeLabel.getText(), "Bed Type label text should be 'Bed Type'");

        assertNotNull(roomNumberLabel, "Room Number label should be initialized");
        assertEquals("Room Number", roomNumberLabel.getText(), "Room Number label text should be 'Room Number'");
    }

    @Test
    void testActionPerformedLoadData() {
        JButton loadDataButton = (JButton) room.getContentPane().getComponent(1); // 'Load Data' button
        assertDoesNotThrow(() -> loadDataButton.doClick(), "Load Data button click should not throw an exception");
    }


    @Test
    void testActionPerformedBack() {
        JButton backButton = (JButton) room.getContentPane().getComponent(2);
        assertDoesNotThrow(() -> backButton.doClick(), "Back button click should not throw an exception");
        assertFalse(room.isVisible(), "Room frame should not be visible after back button is clicked");
    }

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> Room.main(new String[]{}), "Main method should execute without exceptions");
    }
}
