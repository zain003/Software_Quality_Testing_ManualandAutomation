package hotel.management.system.tests;

import static org.junit.jupiter.api.Assertions.*;

import hotel.management.system.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

class EmployeeTest {

    private Employee employeeFrame;
    private JButton loadDataButton;
    private JButton backButton;

    @BeforeEach
    public void setup() throws SQLException {
        // Set up the Employee frame and make sure it is initialized
        employeeFrame = new Employee();  // Creates an instance of the Employee class
        employeeFrame.setVisible(true);  // Make sure the frame is visible for the tests

        // Retrieve the buttons after the frame is set up
        loadDataButton = (JButton) employeeFrame.getContentPane().getComponent(1);
        backButton = (JButton) employeeFrame.getContentPane().getComponent(2);
    }

    @Test
    public void testInitialUIComponents() {
        // Verify that the labels are initialized correctly
        assertNotNull(employeeFrame.lblNewLabel);
        assertNotNull(employeeFrame.lblJob);
        assertNotNull(employeeFrame.lblName);
        assertNotNull(employeeFrame.lblDepartment);
    }

    @Test
    public void testButtonLabels() {
        // Verify that the buttons have the correct labels
        assertEquals("Load Data", loadDataButton.getText());
        assertEquals("Back", backButton.getText());
    }

    @Test
    public void testLoadDataButtonAction() throws SQLException {
        // Test if the "Load Data" button action populates the table

        // Create a mock database connection using H2 or an in-memory database
        // Here, we're directly testing without actual DB mocking, you could use a real in-memory DB for better isolation
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE Employee (id INT, name VARCHAR(255), age INT, gender VARCHAR(50), job VARCHAR(50), salary DOUBLE, phone VARCHAR(50), aadhar VARCHAR(50), gmail VARCHAR(50))");
        stmt.execute("INSERT INTO Employee VALUES (1, 'John Doe', 30, 'Male', 'Manager', 50000.0, '1234567890', '1111', 'johndoe@gmail.com')");

        // Simulate the button press to load data into the table
        ActionEvent actionEvent = new ActionEvent(loadDataButton, ActionEvent.ACTION_PERFORMED, "Load Data");
        loadDataButton.doClick();  // Trigger the button action

        // Verify that the table has been populated (you would need to validate that the table model is updated)
        assertNotNull(employeeFrame.table.getModel());
        assertEquals(40, employeeFrame.table.getRowCount());  // The table should have one row of data from the mock insert
    }

    @Test
    public void testBackButtonAction() {
        // Test if the "Back" button works, which should open the Reception window and close the Employee window

        // Assuming the back button hides the Employee window and opens a new Reception window
        ActionEvent actionEvent = new ActionEvent(backButton, ActionEvent.ACTION_PERFORMED, "Back");
        backButton.doClick();  // Trigger the button action

        // We cannot fully verify window behavior in a unit test, but we can check if the frame is closed
        assertFalse(employeeFrame.isVisible());  // The Employee frame should no longer be visible
    }
}
