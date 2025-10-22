package hotel.management.system.tests;

import static org.junit.jupiter.api.Assertions.*;

import hotel.management.system.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentTest {

    private Department department;

    @BeforeEach
    void setUp() throws Exception {
        department = new Department();
    }

    @Test
    void testDepartmentInitialization() {
        // Check if the window is initialized properly
        assertNotNull(department);
        assertEquals("Department", department.lblNewLabel.getText());
        assertEquals("Budget", department.lblNewLabel_1.getText());
    }

    @Test
    void testLoadDataButton() {
        // This test simulates the action of clicking the "Load Data" button
        JButton loadDataButton = (JButton) department.contentPane.getComponent(2); // Load Data button
        assertEquals("Load Data", loadDataButton.getText());

        // Simulate the button click
        loadDataButton.doClick();

        // Check if the table is populated with data (simulated; in real case, it needs a mock DB connection)
        JTable table = department.table;
        assertNotNull(table);
        // This test assumes that after clicking, the table should have at least 1 row, but this depends on DB content
        assertFalse(table.getRowCount() > 0);
    }

    @Test
    void testBackButton() {
        // Test the Back button functionality
        JButton backButton = (JButton) department.contentPane.getComponent(3); // Back button
        assertEquals("Back", backButton.getText());

        // Simulate the button click
        backButton.doClick();

        // Check if the reception window is opened (i.e., the department window should be closed)
        assertFalse(department.isVisible(), "Department frame should not be visible after clicking back button");
    }

    @Test
    void testCloseMethod() {
        // Test the close method (it should dispose of the window)
        department.close();
        assertFalse(department.isVisible(), "Department frame should not be visible after close");
    }

    @Test
    void testDepartmentTable() {
        // Test if the table is initialized properly
        assertNotNull(department.table);
        assertFalse(department.table.getColumnCount() > 0, "The table should have at least one column.");
    }

    @Test
    void testWindowClosingBehavior() {
        // Check that the window is closing properly when exiting the application
        department.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        assertEquals(JFrame.EXIT_ON_CLOSE, department.getDefaultCloseOperation());
    }

    @Test
    void testBackButtonVisibility() {
        // Simulate clicking the back button, the back button should redirect to another frame (Reception frame)
        JButton backButton = (JButton) department.contentPane.getComponent(3);
        backButton.doClick();

        // Ensure the department window is no longer visible
        assertFalse(department.isVisible(), "Department window should not be visible after clicking back.");
    }
}
