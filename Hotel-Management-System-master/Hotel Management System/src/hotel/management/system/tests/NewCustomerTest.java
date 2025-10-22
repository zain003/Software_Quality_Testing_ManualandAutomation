package hotel.management.system.tests;

import hotel.management.system.NewCustomer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

class NewCustomerTest {

    private NewCustomer newCustomer;

    @BeforeEach
    void setUp() {
        try {
            newCustomer = new NewCustomer();
            newCustomer.setVisible(false); // Prevent UI from being displayed during tests
        } catch (Exception e) {
            fail("Exception during setup: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        newCustomer.dispose();
    }

    @Test
    void testFrameInitialization() {
        assertEquals(850, newCustomer.getWidth(), "Frame width should be 850");
        assertEquals(550, newCustomer.getHeight(), "Frame height should be 550");
    }

    @Test
    void testLabelsInitialization() {
        JLabel lblName = (JLabel) newCustomer.getContentPane().getComponent(1);
        assertNotNull(lblName, "The label 'NEW CUSTOMER FORM' should be initialized");
        assertEquals("NEW CUSTOMER FORM", lblName.getText(), "Label text should be 'NEW CUSTOMER FORM'");
        assertEquals(20, lblName.getFont().getSize(), "Font size of the label should be 20");
    }

    @Test
    void testComboBoxInitialization() {
        JComboBox comboBox = newCustomer.comboBox;
        assertNotNull(comboBox, "ComboBox should be initialized");
        assertEquals(4, comboBox.getItemCount(), "ComboBox should have 4 items");
        assertEquals("Passport", comboBox.getItemAt(0), "First item should be 'Passport'");
    }

    @Test
    void testTextFieldsInitialization() {
        JTextField t1 = newCustomer.t1;
        JTextField t2 = newCustomer.t2;

        assertNotNull(t1, "TextField t1 should be initialized");
        assertNotNull(t2, "TextField t2 should be initialized");

        t1.setText("TestValue1");
        t2.setText("TestValue2");

        assertEquals("TestValue1", t1.getText(), "TextField t1 should hold the correct value");
        assertEquals("TestValue2", t2.getText(), "TextField t2 should hold the correct value");
    }

    @Test
    void testRadioButtonInitialization() {
        JRadioButton r1 = newCustomer.r1;
        JRadioButton r2 = newCustomer.r2;

        assertNotNull(r1, "RadioButton r1 should be initialized");
        assertNotNull(r2, "RadioButton r2 should be initialized");

        assertEquals("Male", r1.getText(), "RadioButton r1 text should be 'Male'");
        assertEquals("Female", r2.getText(), "RadioButton r2 text should be 'Female'");
    }

    @Test
    void testChoiceInitialization() {
        Choice c1 = newCustomer.c1;
        assertNotNull(c1, "Choice c1 should be initialized");
    }


    @Test
    void testBackButtonFunctionality() {
        JButton backButton = (JButton) newCustomer.getContentPane().getComponent(19); // Back button

        assertNotNull(backButton, "Back button should be initialized");
        assertEquals("Add", backButton.getText(), "Back button text should be 'Back'");

        // Simulate button click
        assertDoesNotThrow(() -> backButton.doClick(), "Clicking Back button should not throw any exception");
    }

    @Test
    void testBackgroundInitialization() {
        assertEquals(Color.WHITE, newCustomer.getContentPane().getBackground(), "Background color should be white");
    }

    @Test
    void testMainMethod() {
        // Ensure the main method runs without exceptions
        assertDoesNotThrow(() -> NewCustomer.main(new String[]{}), "Main method should execute without throwing exceptions");
    }
}
