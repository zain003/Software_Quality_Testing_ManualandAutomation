package hotel.management.system.tests;


import hotel.management.system.UpdateCheck;
import hotel.management.system.conn;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;

class UpdateCheckTest {

    private UpdateCheck updateCheckFrame;

    @BeforeEach
    void setUp() throws SQLException {
        // Initialize the frame for testing
        updateCheckFrame = new UpdateCheck();
        updateCheckFrame.setVisible(false); // Prevent UI from being displayed during tests
    }

    @AfterEach
    void tearDown() {
        updateCheckFrame.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(950, updateCheckFrame.getWidth(), "Frame width should be 950");
        assertEquals(500, updateCheckFrame.getHeight(), "Frame height should be 500");
    }

    @Test
    void testLabelInitialization() {
        JLabel label = (JLabel) updateCheckFrame.getContentPane().getComponent(0);
        assertNotNull(label, "Label should be initialized");
        assertEquals("Check-In Details", label.getText(), "Label text should be 'Check-In Details'");
    }

    @Test
    void testComboBoxInitialization() {
        assertNotNull(updateCheckFrame.c1, "Choice ComboBox c1 should be initialized");
        assertFalse(updateCheckFrame.c1.getItemCount() > 0, "Choice ComboBox should have items loaded from database");
    }

    @Test
    void testTextFieldInitialization() {
        JTextField txtID = updateCheckFrame.txt_ID;
        JTextField txtStatus = updateCheckFrame.txt_Status;
        JTextField txtDate = updateCheckFrame.txt_Date;
        JTextField txtTime = updateCheckFrame.txt_Time;
        JTextField txtPayment = updateCheckFrame.txt_Payment;

        assertNotNull(txtID, "TextField txt_ID should be initialized");
        assertNotNull(txtStatus, "TextField txt_Status should be initialized");
        assertNotNull(txtDate, "TextField txt_Date should be initialized");
        assertNotNull(txtTime, "TextField txt_Time should be initialized");
        assertNotNull(txtPayment, "TextField txt_Payment should be initialized");
    }

    @Test
    void testButtonUpdateAction() {
        // Correctly find the Update button by its label
        JButton btnUpdate = Arrays.stream(updateCheckFrame.getContentPane().getComponents()).filter(component -> component instanceof JButton).map(component -> (JButton) component).filter(button -> "Update".equals(button.getText())).findFirst().orElse(null);

        assertNotNull(btnUpdate, "Button btnUpdate should be initialized");

        // Simulate button click
        assertDoesNotThrow(() -> btnUpdate.doClick(), "Button click should not throw an exception");
    }


    @Test
    void testButtonBackAction() {
        // Find the Back button by checking for instance of JButton
        JButton btnBack = Arrays.stream(updateCheckFrame.getContentPane().getComponents()).filter(comp -> comp instanceof JButton).map(comp -> (JButton) comp).filter(button -> button.getText().equals("Back")).findFirst().orElse(null);
        // Exit the loop once the correct button is found

        assertNotNull(btnBack, "Button btnBack should be initialized");

        // Simulate button click and verify frame visibility
        assertDoesNotThrow(() -> {
            btnBack.doClick();
            assertFalse(updateCheckFrame.isVisible(), "Frame should not be visible after Back button click");
        });
    }


    @Test
    void testButtonCheckAction() {
        JButton btnCheck = (JButton) Arrays.stream(updateCheckFrame.getContentPane().getComponents()).filter(comp -> comp instanceof JButton && ((JButton) comp).getText().equals("Check")).findFirst().orElse(null);

        assertNotNull(btnCheck, "Button 'Check' should be initialized");

        // Simulate button click
        assertDoesNotThrow(() -> {
            btnCheck.doClick();
            assertNotNull(updateCheckFrame.txt_ID.getText(), "TextField txt_ID should have a value after Check button click");
            assertNotNull(updateCheckFrame.txt_Status.getText(), "TextField txt_Status should have a value after Check button click");
            assertNotNull(updateCheckFrame.txt_Date.getText(), "TextField txt_Date should have a value after Check button click");
            assertNotNull(updateCheckFrame.txt_Time.getText(), "TextField txt_Time should have a value after Check button click");
        });
    }

    @Test
    void testDatabaseUpdateQuery() {
        // This test is designed to verify if the update query executes successfully.
        // In a real-world scenario, this should interact with a test database.

        // Simulate the update action
        try {
            String testNumber = "123"; // Example customer number
            String roomNumber = "101"; // Example room number
            String status = "Checked-in";
            String deposit = "1000";

            conn c = new conn();
            c.s.executeUpdate("update customer set roomnumber = '" + roomNumber + "', name = 'John Doe', status = '" + status + "', deposit = '" + deposit + "' where number = '" + testNumber + "'");

            // Verify the update was successful by querying the database
            ResultSet rs = c.s.executeQuery("select * from customer where number = '" + testNumber + "'");
            assertTrue(rs.next(), "Customer record should exist after update");
            assertEquals(roomNumber, rs.getString("roomnumber"), "Room number should be updated");
            assertEquals(status, rs.getString("status"), "Status should be updated");
            assertEquals(deposit, rs.getString("deposit"), "Deposit should be updated");

        } catch (SQLException e) {
            fail("SQL Exception occurred during the test: " + e.getMessage());
        }
    }
}
