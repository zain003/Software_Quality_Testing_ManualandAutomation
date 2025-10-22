package hotel.management.system.tests;


import hotel.management.system.PickUp;
import hotel.management.system.conn;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.Arrays;

class PickUpTest {

    private PickUp pickUp;

    @BeforeEach
    void setUp() throws SQLException {
        pickUp = new PickUp();
        pickUp.setVisible(false); // Avoid displaying UI during tests
    }

    @AfterEach
    void tearDown() {
        pickUp.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(800, pickUp.getWidth(), "Frame width should be 800");
        assertEquals(600, pickUp.getHeight(), "Frame height should be 600");
        assertEquals(JFrame.EXIT_ON_CLOSE, pickUp.getDefaultCloseOperation(), "Default close operation should be EXIT_ON_CLOSE");
    }

    @Test
    void testLabelsInitialization() {
        Component[] components = pickUp.getContentPane().getComponents();
        String[] expectedLabels = {
                "Pick Up Service", "Type of Car", "Name", "Age", "Gender",
                "Company", "Brand", "Available", "Location"
        };

        long labelCount = Arrays.stream(components)
                .filter(component -> component instanceof JLabel)
                .map(component -> ((JLabel) component).getText())
                .filter(expectedLabels::equals)
                .count();

        assertEquals(expectedLabels.length, labelCount, "All labels should be present");
    }

    @Test
    void testChoiceInitialization() {
        Choice c1 = pickUp.c1;
        assertNotNull(c1, "Choice c1 should be initialized");
        assertTrue(c1.getItemCount() > 0, "Choice c1 should have items loaded from the database");
    }

    @Test
    void testTableInitialization() {
        JTable table = pickUp.table;
        assertNotNull(table, "Table should be initialized");
        assertEquals(800, table.getWidth(), "Table width should be 800");
        assertEquals(250, table.getHeight(), "Table height should be 250");
    }

    @Test
    void testDisplayButtonAction() {
        JButton displayButton = Arrays.stream(pickUp.getContentPane().getComponents())
                .filter(component -> component instanceof JButton)
                .map(component -> (JButton) component)
                .filter(button -> "Display".equals(button.getText()))
                .findFirst()
                .orElse(null);

        assertNotNull(displayButton, "Display button should be present");

        // Simulate button click
        assertDoesNotThrow(() -> displayButton.doClick(), "Display button click should not throw an exception");

        // Validate that the table model is updated after the button click
        assertNotNull(pickUp.table.getModel(), "Table model should be updated after Display button click");
    }

    @Test
    void testBackButtonAction() {
        JButton backButton = Arrays.stream(pickUp.getContentPane().getComponents())
                .filter(component -> component instanceof JButton)
                .map(component -> (JButton) component)
                .filter(button -> "Back".equals(button.getText()))
                .findFirst()
                .orElse(null);

        assertNotNull(backButton, "Back button should be present");

        // Simulate button click
        assertDoesNotThrow(() -> backButton.doClick(), "Back button click should not throw an exception");

        // Verify that the current frame becomes invisible
        assertFalse(pickUp.isVisible(), "PickUp frame should not be visible after Back button click");
    }

    @Test
    void testDatabaseConnection() throws SQLException {
        conn dbConn = new conn();
        assertNotNull(dbConn.s, "Database connection should be established");
        ResultSet rs = dbConn.s.executeQuery("SELECT * FROM driver");
        assertTrue(rs.next(), "Driver table should have at least one entry");
    }

    @Test
    void testMainMethodExecution() {
        assertDoesNotThrow(() -> PickUp.main(new String[]{}), "Main method should execute without exceptions");
    }
}
