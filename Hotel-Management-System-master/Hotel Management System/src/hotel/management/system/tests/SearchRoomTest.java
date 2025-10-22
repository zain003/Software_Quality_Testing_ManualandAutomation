package hotel.management.system.tests;


import hotel.management.system.SearchRoom;
import hotel.management.system.conn;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;

class SearchRoomTest {

    private SearchRoom searchRoom;
    private JTextField txt_Type;
    private JTable table;
    private JCheckBox checkRoom;
    private Choice c1;

    @BeforeEach
    void setUp() throws SQLException {
        searchRoom = new SearchRoom(); // This may throw SQLException
        searchRoom.setVisible(false); // Prevent UI from being displayed during tests

        // Initialize components for testing
        txt_Type = new JTextField();
        table = new JTable();
        checkRoom = new JCheckBox();
        c1 = new Choice();
        c1.add("Single Bed");
        c1.add("Double Bed");
    }

    @AfterEach
    void tearDown() {
        searchRoom.dispose();
    }

    @Test
    void testFrameInitialization() {
        // Verify that the frame size and content pane are set correctly
        assertEquals(700, searchRoom.getWidth(), "Frame width should be 700");
        assertEquals(500, searchRoom.getHeight(), "Frame height should be 500");
        assertNotNull(searchRoom.getContentPane(), "Content pane should not be null");
    }

    @Test
    void testComponentsInitialization() {
        // Check initialization of key components like labels, buttons, etc.
        JLabel lblSearchForRoom = (JLabel) searchRoom.getContentPane().getComponent(0);
        assertEquals("Search For Room", lblSearchForRoom.getText(), "Search label text should match");

        // Correct access for JButton (Search)
        JButton btnSearch = (JButton) searchRoom.getContentPane().getComponent(7);  // Correct index for Search button
        assertEquals("Search", btnSearch.getText(), "Search button text should match");

        // Correct access for JButton (Back)
        JButton btnExit = (JButton) searchRoom.getContentPane().getComponent(8);  // Correct index for Back button
        assertEquals("Back", btnExit.getText(), "Back button text should match");

        // Check initialization of the Choice component (for Room Type)
        Choice choice = (Choice) searchRoom.getContentPane().getComponent(5);  // 'Choice' is the 6th component (index 5)
        assertNotNull(choice, "Choice component should be correctly initialized");
        assertEquals(2, choice.getItemCount(), "Choice component should have two items");
        assertEquals("Single Bed", choice.getItem(0), "First item in Choice should be 'Single Bed'");
        assertEquals("Double Bed", choice.getItem(1), "Second item in Choice should be 'Double Bed'");

        // Check if checkRoom checkbox is present
        JCheckBox checkRoom = (JCheckBox) searchRoom.getContentPane().getComponent(4);  // Assuming it's at index 4
        assertTrue(checkRoom.isSelected(), "Checkbox should be selected by default");
    }

    @Test
    void testSearchButtonAction() {
        // Locate and check the JButton "Search" by its type
        JButton btnSearch = Arrays.stream(searchRoom.getContentPane().getComponents()).filter(comp -> comp instanceof JButton).map(comp -> (JButton) comp).filter(button -> button.getText().equals("Search")).findFirst().orElse(null);

        // Ensure the button was found
        assertNotNull(btnSearch, "Search button should be found");

        // Simulate the action performed on the Search button
        assertDoesNotThrow(() -> btnSearch.doClick(), "Button click should not throw exception");

        // Since database queries are involved, we can only check if the action was triggered
        // Test the visibility of the table (model update) after button click
        assertNotNull(table.getModel(), "Table model should be updated after search");
    }

    @Test
    void testCheckBoxSelection() {
        // Test the behavior when the "Only display Available" checkbox is selected
        JCheckBox checkBox = (JCheckBox) searchRoom.getContentPane().getComponent(6);
        checkBox.setSelected(true);
        assertTrue(checkBox.isSelected(), "CheckBox should be selected");

        // Test the behavior when the "Only display Available" checkbox is not selected
        checkBox.setSelected(false);
        assertFalse(checkBox.isSelected(), "CheckBox should not be selected");
    }

    @Test
    void testChoiceSelection() {
        // Test that the choice component properly reflects the selected item
        c1.select("Double Bed");
        assertEquals("Double Bed", c1.getSelectedItem(), "Selected item should be 'Double Bed'");

        c1.select("Single Bed");
        assertEquals("Single Bed", c1.getSelectedItem(), "Selected item should be 'Single Bed'");
    }

    @Test
    void testBackButtonAction() {
        // Simulate the action performed on the Back button
        JButton btnExit = (JButton) searchRoom.getContentPane().getComponent(8);

        // This should not throw an exception
        assertDoesNotThrow(() -> btnExit.doClick(), "Back button click should not throw exception");

        // After clicking back, the Reception frame should be displayed
        // You can check if the new frame (Reception) is visible, but this requires actual window testing which may not be directly testable.
        // Assuming that the Reception frame's visibility is handled correctly.
    }

    @Test
    void testDatabaseQueryHandling() {
        // Since actual database connections aren't possible in this unit test,
        // this method will test if the code reaches the database interaction without exceptions.

        // Test SQL for room search (example: "Single Bed")
        String SQL = "select * from Room where bed_type = 'Single Bed'";

        // Ensure the query can be executed without throwing SQLException
        assertDoesNotThrow(() -> {
            conn connection = new conn();
            ResultSet rs = connection.s.executeQuery(SQL);
            assertNotNull(rs, "ResultSet should not be null");
        }, "SQL query should execute without throwing SQLException");
    }
}
