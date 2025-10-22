package hotel.management.system.tests;
import hotel.management.system.AddEmployee;
import org.junit.jupiter.api.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static org.junit.jupiter.api.Assertions.*;

class AddEmployeeTest {

    private AddEmployee addEmployee;

    @BeforeEach
    void setUp() {
        // Initialize the AddEmployee frame before each test
        addEmployee = new AddEmployee();
    }

    @AfterEach
    void tearDown() {
        // Dispose of the frame after each test
        addEmployee.dispose();
    }

    @Test
    void testInitialValues() {
        // Verify that all fields are empty initially
        assertEquals("", addEmployee.textField.getText());
        assertEquals("", addEmployee.textField_1.getText());
        assertEquals("", addEmployee.textField_3.getText());
        assertEquals("", addEmployee.textField_4.getText());
        assertEquals("", addEmployee.textField_5.getText());
        assertEquals("", addEmployee.textField_6.getText());

        // Verify that the JComboBox has the first item selected
        assertEquals("Front Desk Clerks", addEmployee.c1.getSelectedItem());
    }

    @Test
    void testFormValidation_AllFieldsEmpty() {
        // Simulate a button click with all fields empty
        addEmployee.textField.setText("");
        addEmployee.textField_1.setText("");
        addEmployee.textField_3.setText("");
        addEmployee.textField_4.setText("");
        addEmployee.textField_5.setText("");
        addEmployee.textField_6.setText("");

        // Simulate clicking the save button
        ActionEvent e = new ActionEvent(addEmployee.btnSave, ActionEvent.ACTION_PERFORMED, null);
        addEmployee.btnSave.getActionListeners()[0].actionPerformed(e);

        // Assert that a JOptionPane was shown with the correct message
        // Note: JOptionPane tests may require mocking or integration testing
    }

    @Test
    void testFormValidation_MissingGender() {
        // Fill in all fields except gender
        addEmployee.textField.setText("John Doe");
        addEmployee.textField_1.setText("25");
        addEmployee.textField_3.setText("50000");
        addEmployee.textField_4.setText("1234567890");
        addEmployee.textField_5.setText("123456789012");
        addEmployee.textField_6.setText("john.doe@example.com");

        // Simulate clicking the save button
        ActionEvent e = new ActionEvent(addEmployee.btnSave, ActionEvent.ACTION_PERFORMED, null);
        addEmployee.btnSave.getActionListeners()[0].actionPerformed(e);

        // Assert that a JOptionPane was shown with the correct message
    }

    @Test
    void testFormValidation_ValidInput() {
        // Fill in all fields with valid data
        addEmployee.textField.setText("John Doe");
        addEmployee.textField_1.setText("25");
        addEmployee.textField_3.setText("50000");
        addEmployee.textField_4.setText("1234567890");
        addEmployee.textField_5.setText("123456789012");
        addEmployee.textField_6.setText("john.doe@example.com");
        addEmployee.rbMale.setSelected(true);
        addEmployee.c1.setSelectedItem("Manager");

        // Simulate clicking the save button
        ActionEvent e = new ActionEvent(addEmployee.btnSave, ActionEvent.ACTION_PERFORMED, null);
        addEmployee.btnSave.getActionListeners()[0].actionPerformed(e);

        // Assert that the frame is no longer visible (successful submission)
        assertFalse(addEmployee.isVisible());
    }

    @Test
    void testComboBoxJobs() {
        // Verify that all expected job options are present in the JComboBox
        String[] expectedJobs = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service",
                "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        for (int i = 0; i < expectedJobs.length; i++) {
            assertEquals(expectedJobs[i], addEmployee.c1.getItemAt(i));
        }
    }
}
